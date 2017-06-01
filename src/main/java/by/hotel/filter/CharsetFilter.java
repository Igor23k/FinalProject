package by.hotel.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "charsetfilter",
        urlPatterns = {"/servlet"},
        initParams = @WebInitParam(name = "env", value = "dev"))
public class CharsetFilter implements Filter {
    private String characterEncoding;
    private ServletContext servletContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(characterEncoding);
        response.setCharacterEncoding(characterEncoding);
        servletContext.log("charset is set");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) {
        characterEncoding = config.getInitParameter("characterEncoding");
        if (characterEncoding != null)
            characterEncoding = characterEncoding.trim();
        else
            characterEncoding = "UTF-8";
        servletContext=config.getServletContext();
    }
    @Override
    public void destroy() {
    }
}
