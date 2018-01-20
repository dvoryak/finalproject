package controller.command;

import com.google.gson.Gson;
import model.entity.Report;
import model.entity.User;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class CabinetAjaxCommand implements Command {

    private ReportService reportService;

    public CabinetAjaxCommand(ReportService reportService) {
        this.reportService = reportService;
    }

    private List<Report> reports = new ArrayList<>();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user.getRole().equals("Inspector")) {
            reports = reportService.findByInspectorId(user.getId());
        } else if(user.getRole().equals("Client")) {
            reports = reportService.findByUserId(user.getId());
        }
        String name = request.getParameter("status");
        String resp = null;
        if(name != null) {
            switch (name) {
                case "ok":
                    resp = getJSON(reports.stream().filter(report -> report.getStatus() == Report.Status.OK).collect(Collectors.toList()));
                    break;
                case "failed":
                    resp = getJSON(reports.stream().filter(report -> report.getStatus() == Report.Status.FAILED).collect(Collectors.toList()));
                    break;
                case "unchecked":
                    resp = getJSON(reports.stream().filter(report -> report.getStatus() == Report.Status.UNCHECKED).collect(Collectors.toList()));
                    break;
                case "checked" :
                    resp = getJSON(reports.stream().filter(report -> report.getStatus() != Report.Status.UNCHECKED).collect(Collectors.toList()));
                    break;
            }

            try {
                response.getWriter().append(resp);
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }

        }

        return null;
    }

    private String getJSON(List<Report> reports) {
        Gson gson = new Gson();
        return gson.toJson(reports);
    }

}
