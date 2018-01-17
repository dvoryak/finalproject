package service.impl;

import dao.ReportDAO;
import dao.mysqlDaoImpl.ReportDAOImpl;
import model.entity.Report;
import service.ReportService;

import java.sql.SQLException;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    private ReportDAO reportDAO;

    public ReportServiceImpl(ReportDAO reportDAO) {
        this.reportDAO = reportDAO;
    }

    @Override
    public boolean save(Report report) throws SQLException {
        return reportDAO.save(report);
    }

    @Override
    public List<Report> findAll() throws SQLException {
        return reportDAO.findAll();
    }

    @Override
    public List<Report> findByUserId(int id) throws SQLException {
        return reportDAO.findByUserId(id);
    }

    @Override
    public Report findById(int id) throws SQLException {
        return reportDAO.findById(id);
    }

    @Override
    public boolean update(Report report) throws SQLException {
        return reportDAO.update(report);
    }

    @Override
    public List<Report> findByInspectorId(int id) throws SQLException {
        return reportDAO.findByInspectorId(id);
    }
}
