package controller.command;


import controller.constant.Pages;
import service.impl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public enum CommandExecutor {
    INSTANCE;

    private Map<Type,Command> commandMap = new HashMap<>();
    {
        commandMap.put(Type.LANGUAGE_CHANGE,new ChangeLanguageCommand());
        commandMap.put(Type.REGISTER_PAGE,new PageRegisterCommand());
        commandMap.put(Type.LOGIN_PAGE, new PageLoginCommand());
        commandMap.put(Type.LOGOUT, new LogoutCommand());
        commandMap.put(Type.LOGIN_CLIENT,new LoginClientCommand(new ServiceFactoryImpl().createUserService(null)));
        commandMap.put(Type.LOGIN_INSPECTOR,new LoginInspectorCommand());
        commandMap.put(Type.CLIENT_CABINET,new PageClientCabinet());
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
