package by.hotel.servlet;

import by.hotel.bean.DocumentObject;
import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.factory.impl.CommandFactoryMapper;
import by.hotel.resource.LocalizationManager;
import by.hotel.tag.GetDateTag;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.Map;

/**
 * MainServlet.java
 * Class represents a requests handler.
 * Class extents from HttpServlet
 *
 * @author Igor Kozlov
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/servlet"})
public class MainServlet extends HttpServlet {
    /**
     * It is a logger which print some messages to log file.
     */
    private static final Logger logger = Logger.getLogger(MainServlet.class);

    /**
     * The method is called when processing requests
     *
     * @param request  an request to be processed
     * @param response an response to be returned
     */
    private void doRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Object result = null;
            Object data;
            String locale;
            Gson gsonData = new Gson();
            GetDateTag dateTag = new GetDateTag();
            String page = request.getParameter("page");
            String action = request.getParameter("action");
            String localePage = request.getParameter("localePage");
            Map<String, String[]> list = request.getParameterMap();
            CommandFactoryMapper commandFactoryMapper = CommandFactoryMapper.getInstance();
            if (action != null) {
                ICommand command = commandFactoryMapper.getCommand(action);
                result = command.execute(request,response);
            }else{
                action="";
            }
            LocalizationManager localizationManager = new LocalizationManager();
            if (request.getParameter("locale") != null) {
                locale = request.getParameter("locale");
            } else {
                locale = "ru";
            }
            data = localizationManager.getValue(locale, localePage);
            dateTag.setLocale(locale);
            if (page != null) {
                request.setAttribute("items", result);
                request.setAttribute("data", data);
                request.getRequestDispatcher(page).forward(request, response);
            } else if (!(action.equals("CREATE_DOC"))){
                JsonObject pageData = new JsonObject();
                pageData.add("data", gsonData.toJsonTree(result));
                pageData.add("local", gsonData.toJsonTree(data));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String s = String.valueOf(pageData);
                response.getWriter().write(s);
            }
        } catch (CommandException e) {
            logger.error(e);
            String message = e.getMessage();
            try {
                response.getWriter().write(convertToGson(message.substring(message.lastIndexOf(":") + 1)).toString());
            } catch (IOException e1) {
                convertToGson(message.substring(message.lastIndexOf(":") + 1));
            }
        } catch (IOException | ServletException e) {
            logger.error(e);
        }
    }

    /**
     * The method is processing GET requests
     *
     * @param request  an request to be processed
     * @param response an response to be returned
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doRequest(request, response);
    }

    /**
     * The method is processing POST requests
     *
     * @param request  an request to be processed
     * @param response an response to be returned
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doRequest(request, response);
    }

    /**
     * The method is processing DELETE requests
     *
     * @param request  an request to be processed
     * @param response an response to be returned
     */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        doRequest(request, response);
    }

    /**
     * The method is converting object to Gson format
     *
     * @param object that needed to convert
     * @return The Gson format object.
     */
    private Gson convertToGson(Object object) {
        Gson jsonConverter = new Gson();
        jsonConverter.toJson(object);
        return jsonConverter;
    }
}
