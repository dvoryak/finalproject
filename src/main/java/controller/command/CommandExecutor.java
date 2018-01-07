package controller.command;


import controller.constant.Pages;
import dao.pool.ConnectionPool;
import service.impl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static controller.command.Type.*;

public enum CommandExecutor {
    INSTANCE;

    private Map<Type,Command> commandMap = new HashMap<>();
    {
        commandMap.put(LANGUAGE_CHANGE,new ChangeLanguageCommand());
        commandMap.put(REGISTER_PAGE,new PageRegisterCommand());
        commandMap.put(LOGIN_PAGE, new PageLoginCommand());
        commandMap.put(LOGOUT, new LogoutCommand());
        commandMap.put(LOGIN,new LoginCommand(new ServiceFactoryImpl().createClientService(),
                        new ServiceFactoryImpl().createInspectorService()
        ));
        commandMap.put(CLIENT_CABINET,new PageClientCabinet());
        commandMap.put(REGISTER,new RegisterCommand(new ServiceFactoryImpl()
                .createClientService()));
        commandMap.put(ABOUT_US,new PageAboutUsCommand());
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String command = (String) request.getAttribute("command");


        if (command == null) {
            command = (String) request.getParameter("command");
        }

        if(command == null) return Pages.LOGIN;
        return commandMap.get(Type.valueOf(command.toUpperCase())).execute(request, response);
    }
}
