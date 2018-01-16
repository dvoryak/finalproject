package dao;

import model.entity.Report;

import java.util.List;

public interface ReportDAO {

    boolean update(Report report);

    boolean save(Report report);

    List<Report> findAll();

    List<Report> findByUserId(int id);

    List<Report> findByInspectorId(int id);

    Report findById(int id);
}
