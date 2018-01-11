package controller.command;

import controller.constant.Pages;
import model.entity.ReportPayer;
import model.entity.Report;
import model.entity.ReportActivities;
import model.entity.Client;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class CreateReportCommand implements Command {

    private ReportService reportService;

    public CreateReportCommand(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String middleName = request.getParameter("middleName");
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String home = request.getParameter("home");
        String postal = request.getParameter("postal");

        ReportPayer reportPayer = new ReportPayer.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName)
                .phone(phone)
                .passport(passport)
                .city(city)
                .street(street)
                .home(home)
                .postalCode(postal)
                .build();


        String[] names = request.getParameterValues("name");
        String[] texts = request.getParameterValues("text");
        Set<ReportActivities> activities = new HashSet<>();

        for (int i = 0; i < names.length; i++) {
            ReportActivities ra = new ReportActivities();
            ra.setName(names[i]);
            ra.setText(texts[i]);
            activities.add(ra);
        }

        String institute = request.getParameter("institute");
        int employeeNum = Integer.parseInt(request.getParameter("employeeNum"));
        String date = request.getParameter("date");

        Report report = new Report.Builder()
                .institute(institute)
                .employeeNumber(employeeNum)
                .date(Date.valueOf(date))
                .activities(activities)
                .payer(reportPayer)
                .status(Report.Status.UNCECKED)
                .user((Client) request.getSession().getAttribute("user"))
                .build();

        reportService.save(report);

        return Pages.CLIENT_CABINET;
    }
}
