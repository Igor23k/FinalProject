package by.hotel.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * CharsetFilter.java
 * Class implements methods from interface Filter.
 * doFilter - method to processing request
 * init - method to initialization parameters
 * destroy - method to destroy parameters
 * @author Igor Kozlov
 * @version 1.0
 */
@WebFilter(filterName = "charsetfilter",
        urlPatterns = {"/servlet"},
        initParams = @WebInitParam(name = "env", value = "dev"))
public class CharsetFilter implements Filter {
    /**
     * Property - characterEncoding
     */
    private String characterEncoding;
    /**
     * Property - servletContext
     */
    private ServletContext servletContext;

    /**
     * Method to processing request.
     * @param request the operand to use to get different values.
     * @param response the operand to use to send response.
     * @param chain the operand to use to transfer control.
     * @throws IOException,ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(characterEncoding);
        response.setCharacterEncoding(characterEncoding);
        chain.doFilter(request, response);
    }

    /**
     * Method to initializations parameters.
     * @param config the operand to use for get config parameters.
     */
    @Override
    public void init(FilterConfig config) {
        characterEncoding = config.getInitParameter("characterEncoding");
        if (characterEncoding != null)
            characterEncoding = characterEncoding.trim();
        else
            characterEncoding = "UTF-8";
        servletContext=config.getServletContext();
    }
    /**
     * Method to destroy filter parameters.
     */
    @Override
    public void destroy() {}
}
