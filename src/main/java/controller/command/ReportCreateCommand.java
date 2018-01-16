package controller.command;

import controller.constant.Pages;
import model.entity.ReportPayer;
import model.entity.Report;
import model.entity.ReportActivities;
import model.entity.Client;
import service.ReportService;
import service.factory.ServiceFactoryImpl;
import util.InspectorSelectStrategy;
import util.RandomSelectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ReportCreateCommand implements Command {

    private ReportService reportService;
    private InspectorSelectStrategy selectStrategy;

    public ReportCreateCommand(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        selectStrategy = new RandomSelectStrategy(new ServiceFactoryImpl());

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String middleName = request.getParameter("middleName");
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String home = request.getParameter("home");
        String[] names = request.getParameterValues("name");
        String[] texts = request.getParameterValues("text");
        List<ReportActivities> activities = new ArrayList<>();

        ReportPayer reportPayer = new ReportPayer.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName)
                .phone(phone)
                .passport(passport)
                .city(city)
                .street(street)
                .home(home)
                .build();
        reportPayer.setId(reportPayer.hashCode());




        String institute = request.getParameter("institute");
        int employeeNum = Integer.parseInt(request.getParameter("employeeNum"));
        String date = request.getParameter("date");

        Report report = new Report.Builder()
                .institute(institute)
                .employeeNumber(employeeNum)
                .date(Date.valueOf(date))
                .activities(activities)
                .payer(reportPayer)
                .status(Report.Status.UNCHECKED)
                .user((Client) request.getSession().getAttribute("user"))
                .inspector(selectStrategy.getInspector())
                .build();
        report.setId(report.hashCode());


        for (int i = 0; i < names.length; i++) {
            ReportActivities ra = new ReportActivities();
            ra.setName(names[i]);
            ra.setText(texts[i]);
            ra.setReportId(report.getId());
            activities.add(ra);
        }

        reportService.save(report);

        return Pages.CLIENT_CABINET;
    }
}
