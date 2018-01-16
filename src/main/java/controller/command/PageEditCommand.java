package controller.command;

import controller.constant.Pages;
import model.entity.Report;
import model.entity.User;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageEditCommand implements Command {

    private ReportService reportService;

    public PageEditCommand(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");
        Report report = reportService.findById(id);
        request.getSession().setAttribute("report",report);
        return Pages.EDIT;
    }
}
