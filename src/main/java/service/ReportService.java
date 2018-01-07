package service;

import dao.ReportDAO;
import model.entity.Report;

import java.util.List;

public interface ReportService {

    boolean add(ReportDAO reportDAO);

    List<Report> findAll();

    List<Report> findByUserId(long id);

    List<Report> findByInspectorId(long id);

}
