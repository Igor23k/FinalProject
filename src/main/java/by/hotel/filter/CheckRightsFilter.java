package by.hotel.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * CheckRightsFilter.java
 * Class implements methods from interface Filter.
 * doFilter - method to processing request
 * init - method to initialization parameters
 * destroy - method to destroy parameters
 * @author Igor Kozlov
 * @version 1.0
 */
@WebFilter(filterName = "checkrightsfilter",
        urlPatterns = {"/servlet"},
        initParams = @WebInitParam(name = "env", value = "dev"))
public class CheckRightsFilter implements Filter {
    /**
     * Field - this field stores user's rights
     */
    final private static Map<String, Integer> rights = new HashMap();

    static {
        rights.put("ADMIN_START", 127);
        rights.put("GET_ALL", 4);
        rights.put("ADD", 16);
        rights.put("REMOVE", 32);
        rights.put("UPDATE", 64);
        rights.put("GET_ALL_HEADERS", 127);
        rights.put("AUTHORIZATION", 4);
        rights.put("REGISTRATION", 4);
    }

    /**
     * Field - filterConfig
     */
    private FilterConfig filterConfig = null;

    /**
     * Method to initializations parameters.
     * @param filterConfig the operand to use for get config parameters.
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    /**
     * Method to processing request.
     * @param request the operand to use to get different values.
     * @param response the operand to use to send response.
     * @param chain the operand to use to transfer control.
     * @throws IOException,ServletException
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Integer requiredRight = 0;
        Integer userRights;
        if(request.getParameter("action")!= null) {
            requiredRight = rights.get(request.getParameter("action"));
        }
        //userRights = Integer.parseInt(request.getParameter("rights"));
        userRights = 127;
        if ((requiredRight & userRights) == requiredRight) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("errorPage").forward(request, response);
        }
    }
    /**
     * Method to destroy filter parameters.
     */
    public void destroy() {
        filterConfig = null;
    }

}