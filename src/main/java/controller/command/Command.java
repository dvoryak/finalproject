package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */
public interface Command {

    /**
     *
     * @param request {@link HttpServletRequest}
     * @param response {@link HttpServletResponse}
     * @return path to page {@link String}
     * @throws Exception
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
