package filter;

import model.entity.Role;
import model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
                                                                                throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String command = request.getParameter("command");
        User user = (User) request.getSession().getAttribute("user");

        if(command.equals("login_page") || command.equals("register_page") || command.equals("login")) {
            if (user != null) {
                if (user.getRole() == Role.CLIENT) {
                    servletRequest.setAttribute("command", "client_cabinet");
                } else if (user.getRole() == Role.INSPECTOR) {
                    servletRequest.setAttribute("command", "inspector_cabinet");
                }
            } else {
                servletRequest.setAttribute("command", "login_page");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
