package controller.command;

import controller.constant.Pages;
import model.entity.Report;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportCheckCommand implements Command {

    private ReportService reportService;

    public ReportCheckCommand(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String message = request.getParameter("message");
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        Report report = reportService.findById(Integer.parseInt(id));
        report.setMessage(message);
        report.setStatus(Report.Status.valueOf(status));
        reportService.update(report);


        return Pages.INSPECTOR_CABINET;
    }
}
