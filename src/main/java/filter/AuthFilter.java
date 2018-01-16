package filter;

import controller.command.Type;
import model.entity.User;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import static controller.command.Type.*;


@WebFilter(urlPatterns = "/*",
filterName = "AuthFilter")

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String command = servletRequest.getParameter("command");
        User user = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        if(command != null && !command.isEmpty())
        switch (Type.valueOf(command.toUpperCase())) {
            case LOGIN_PAGE :
            case REGISTER_PAGE :
                if(user != null) {
                    if(user.getRole().equals("Inspector"))
                        servletRequest.setAttribute("command",INSPECTOR_CABINET.toString());
                    if(user.getRole().equals("Client"))
                        servletRequest.setAttribute("command",CLIENT_CABINET.toString());
                }
                break;
            case ABOUT_US:
                break;
            case LANGUAGE_CHANGE:
                break;
            case LOGIN:
                break;

            default:
                if(user == null) {
                    servletRequest.setAttribute("command",LOGIN_PAGE.toString());
                }

        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
