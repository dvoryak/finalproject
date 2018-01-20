package controller.command;


import controller.constant.Pages;
import service.impl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static controller.command.CommandType.*;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */
public enum CommandExecutor {
    INSTANCE;

    private Map<CommandType,Command> commandMap = new HashMap<>();
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
        commandMap.put(REPORT_PAGE,new PageReportCreateCommand());
        commandMap.put(CREATE_REPORT, new ReportCreateCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(VIEW_PAGE,new PageReportViewCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(EDIT_PAGE,new PageReportEditCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(REPORT_EDIT, new ReportEditCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(INSPECTOR_CABINET,new PageInspectorCabinet());
        commandMap.put(CHECK_PAGE, new PageReportCheckCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(REPORT_CHECK,new ReportCheckCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(REPORT_EDIT, new ReportEditCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(PAGE_REQUEST_ADD,new PageRequestAdd());
        commandMap.put(PAGE_REQUEST_SHOW,new PageRequestShow(new ServiceFactoryImpl().createUserRequestService()));
        commandMap.put(REQUEST_ADD, new RequestAddCommand(new ServiceFactoryImpl().createUserRequestService()));
        commandMap.put(ACCESS_DENIED,new PageError());
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String command = (String) request.getAttribute("command");


        if (command == null) {
            command = (String) request.getParameter("command");
        }

        if(command == null) return Pages.LOGIN;
        return commandMap.get(CommandType.valueOf(command.toUpperCase())).execute(request, response);
    }
}
