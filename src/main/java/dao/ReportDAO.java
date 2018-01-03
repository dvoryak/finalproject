package dao;

import model.entity.AbstractReport;

import java.util.List;

public interface ReportDAO {

    boolean add(ReportDAO reportDAO);

    List<AbstractReport> findAll();


}
