package controller.command;

import model.entity.Report;
import model.entity.User;
import service.ReportService;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportViewCommand implements Command {

    ServiceFactory serviceFactory;

    public ReportViewCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");
        ReportService reportService = serviceFactory.createReportService();
        Report report = reportService.findById(id);
        request.getSession().setAttribute("report",report);

        return null; //something about null
    }
}
