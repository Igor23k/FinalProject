package by.hotel.servlet;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.factory.impl.CommandFactoryMapper;
import by.hotel.resource.LocalizationManager;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
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

@WebServlet(urlPatterns = {"/servlet"})
public class MainServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(MainServlet.class.getName());

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
                //         request.setAttribute("data", data);
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

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doRequest(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doRequest(req, resp);
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        doRequest(req, resp);
    }

    private Gson convertToGson(Object result) {
        Gson jsonConverter = new Gson();
        jsonConverter.toJson(result);
        return jsonConverter;
        //

    }
}
