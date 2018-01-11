package controller.command;


import controller.constant.Pages;
import service.factory.ServiceFactoryImpl;

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
        commandMap.put(LOGIN,new LoginCommand(new ServiceFactoryImpl()));
        commandMap.put(CLIENT_CABINET,new PageClientCabinet());
        commandMap.put(REGISTER,new RegisterCommand(new ServiceFactoryImpl().createClientService()));
        commandMap.put(ABOUT_US,new PageAboutUsCommand());
        commandMap.put(AJAX,new CabinetAjaxCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(REPORT_PAGE,new PageCreateReportCommand());
        commandMap.put(CREATE_REPORT, new CreateReportCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(VIEW_PAGE,new PageViewCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(EDIT_PAGE,new PageEditCommand());
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
