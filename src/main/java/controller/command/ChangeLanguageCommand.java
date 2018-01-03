package controller.command;

import controller.constant.Pages;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;

public class ChangeLanguageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter("lang");
        if (getCookie(request) != null) {
            Cookie cookie = getCookie(request);
            cookie.setValue(lang);
            response.addCookie(cookie);
        } else {
            response.addCookie(new Cookie("lang", lang));
        }
        String page = (String) request.getParameter("page");

        if(getUrl(page) != null) {
            return getUrl(page);
        }

        return Pages.LOGIN;
    }

    private Cookie getCookie(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("lang")) {
                return cookie;
            }
        }
        return null;
    }

    private String getUrl(String pageName) {
        try {
            if (!pageName.isEmpty()) {
                Field declaredField = Pages.class.getDeclaredField(pageName.toUpperCase());
                return (String) declaredField.get(null);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


}
