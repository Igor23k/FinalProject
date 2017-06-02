package by.hotel.servlet;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.factory.impl.CommandFactoryMapper;
import by.hotel.resource.LocalizationManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * MainServlet.java
 * Class represents a requests handler.
 * Class extents from HttpServlet
 * @version 1.0
 * @autor Igor Kozlov
 */
@WebServlet(urlPatterns = {"/servlet"})
public class MainServlet extends HttpServlet {
    /**
     * The event logger.
     */
    private static final Logger logger = LogManager.getLogger(MainServlet.class.getName());

    /**
     * The method is called when processing requests
     * @param  request  an request to be processed
     * @param  response an response to be returned
     */
    private void doRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Object result = null;
            Object data;
            String locale;
            Gson gsonData = new Gson();
            String page = request.getParameter("page");
            String localePage = request.getParameter("localePage");
            Map<String, String[]> list = request.getParameterMap();
            CommandFactoryMapper commandFactoryMapper = CommandFactoryMapper.getInstance();
                if (request.getParameter("action") != null) {
                ICommand command = commandFactoryMapper.getCommand(request.getParameter("action"));
                result = command.execute(request);
            }
            LocalizationManager localizationManager = new LocalizationManager();
            if (request.getParameter("locale") != null) {
                locale = request.getParameter("locale");
            } else {
                locale = "ru";
            }
            data = localizationManager.getValue(locale,localePage);

            if (page != null) {
                request.setAttribute("items", result);
                request.setAttribute("data", data);
                request.getRequestDispatcher(page).forward(request, response);
            } else {
                JsonObject pageData = new JsonObject();
                pageData.add("data",gsonData.toJsonTree(result));
                pageData.add("local", gsonData.toJsonTree(data));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String s = String.valueOf(pageData);
                 response.getWriter().write(s);
            }
        } catch (CommandException e) {
            logger.error(e);
            String message = e.getMessage();
            convertToGson(message.substring(message.lastIndexOf(":") + 1));
        } catch (IOException e) {
            logger.error(e);
        } catch (ServletException e) {
            logger.error(e);
        }
    }

    /**
     * The method is processing GET requests
     * @param  request  an request to be processed
     * @param  response an response to be returned
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doRequest(request, response);
    }

    /**
     * The method is processing POST requests
     * @param  request  an request to be processed
     * @param  response an response to be returned
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doRequest(request, response);
    }

    /**
     * The method is processing DELETE requests
     * @param  request  an request to be processed
     * @param  response an response to be returned
     */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        doRequest(request, response);
    }

    /**
     * The method is converting object to Gson format
     * @param  object that needed to convert
     * @return  The Gson format object.
     */
    private Gson convertToGson(Object object) {
        Gson jsonConverter = new Gson();
        jsonConverter.toJson(object);
        return jsonConverter;
    }
}
