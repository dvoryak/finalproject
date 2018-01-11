package service;

import dao.ReportDAO;
import model.entity.Report;

import java.util.List;

public interface ReportService {

    boolean save(Report report);

    List<Report> findAll();

    List<Report> findByUserId(int id);

    Report findById(int id);
}
