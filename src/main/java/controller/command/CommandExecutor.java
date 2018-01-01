package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public enum CommandExecutor {
    INSTANCE;

    private Map<Type,Command> commandMap = new HashMap<>();
    {
        commandMap.put(Type.LANGUAGE_CHANGE,new ChangeLanguageCommand());
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String command = (String) request.getAttribute("command");
        System.out.println(request.getParameterMap().get("command")[0]);
        System.out.println("command " + command );
        return commandMap.get(Type.LANGUAGE_CHANGE).execute(request, response);
    }
}
