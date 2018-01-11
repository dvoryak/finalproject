package controller.command;

import com.google.gson.Gson;
import model.entity.Client;
import model.entity.Report;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Date;
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
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Client client = (Client) request.getSession().getAttribute("user");
        reports = reportService.findByUserId(client.getId());
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
                    resp = getJSON(reports.stream().filter(report -> report.getStatus() == Report.Status.UNCECKED).collect(Collectors.toList()));
                    break;
            }

            try {
                response.setContentType("UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().append(resp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private String getJSON(List<Report> reports) {
        Gson gson = new Gson();
        return gson.toJson(reports);
    }

}
