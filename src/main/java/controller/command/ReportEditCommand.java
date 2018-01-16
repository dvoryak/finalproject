package controller.command;

import controller.constant.Pages;
import model.entity.*;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReportEditCommand implements Command {

    private ReportService reportService;

    public ReportEditCommand(ReportService reportService) {
        this.reportService = reportService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Report rep = (Report) request.getSession().getAttribute("report");


        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String middleName = request.getParameter("middleName");
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String home = request.getParameter("home");
        String postal = request.getParameter("postal");

        String[] names = request.getParameterValues("name");
        String[] texts = request.getParameterValues("text");


        try {
            setField("firstName",request.getParameter("firstName"),rep.getPayer());
            setField("lastName",request.getParameter("lastName"),rep.getPayer());
            setField("middleName",request.getParameter("middleName"),rep.getPayer());
            setField("phone",request.getParameter("phone"),rep.getPayer());
            setField("passport",request.getParameter("passport"),rep.getPayer());
            setField("city",request.getParameter("city"),rep.getPayer());
            setField("street",request.getParameter("street"),rep.getPayer());
            setField("home",request.getParameter("home"),rep.getPayer());
            setField("postalCode",request.getParameter("postalCode"),rep.getPayer());

            setField("institute",request.getParameter("institute"),rep);

            if(names != null)
            for (int i = 0; i < names.length; i++) {
                setField("name",names[i],rep.getActivities().get(i));
                setField("text",texts[i],rep.getActivities().get(i));
            }


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        rep.setStatus(Report.Status.UNCHECKED);
        String employeeNumber = request.getParameter("employeeNumber");
        if(employeeNumber != null && !employeeNumber.isEmpty())
             rep.setEmployeeNumber(Integer.parseInt(employeeNumber));
        String date = request.getParameter("date");
        if(date != null && !date.isEmpty())
            rep.setDate(Date.valueOf(request.getParameter("date")));

        reportService.update(rep);
        return Pages.CLIENT_CABINET;

    }

    private  void setField(String field, String value, Object obj) throws NoSuchFieldException, IllegalAccessException {
        if(value != null && !value.isEmpty()) {
            Field declaredField = obj.getClass().getDeclaredField(field);
            declaredField.setAccessible(true);
            declaredField.set(obj,value);
        }
    }




}
