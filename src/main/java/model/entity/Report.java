package model.entity;

import java.util.Date;

public class Report extends AbstractReport {

    private String instituteNAme;
    private int employeeNumber;
    private Date date;


    public Report(int id, int userId, int inspectorId) {
        super(id, userId, inspectorId);
    }


}
