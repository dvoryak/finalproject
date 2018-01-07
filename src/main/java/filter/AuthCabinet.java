package filter;

import model.entity.Role;
import model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class AuthCabinet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String command = request.getParameter("command");
        User user = (User) request.getSession().getAttribute("user");

        if(command != null && command.equals("cabinet")) {
            if(check(user,Role.CLIENT)) {
                servletRequest.setAttribute("command", "client_cabinet");
            } else if(check(user,Role.INSPECTOR)) {
                servletRequest.setAttribute("command", "inspector_cabinet");
            }
        }

        if(command != null) {
            if (command.equals("client_cabinet") && !check(user, Role.CLIENT)) {
                servletRequest.setAttribute("command", "login_page");
            }

            if (command.equals("inspector_cabinet") && !check(user, Role.INSPECTOR)) {
                servletRequest.setAttribute("command", "login_page");
            }
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    private boolean check(User user, Role role) {
        return user != null && user.getRole() == role;
    }


    @Override
    public void destroy() {

    }
}
