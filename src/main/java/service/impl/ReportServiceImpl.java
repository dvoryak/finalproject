package service.impl;

import dao.ReportDAO;
import dao.mysqlDaoImpl.ReportDAOImpl;
import model.entity.Report;
import service.ReportService;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    private ReportDAO reportDAO;

    public ReportServiceImpl(ReportDAO reportDAO) {
        this.reportDAO = reportDAO;
    }

    @Override
    public boolean save(Report report) {
        return reportDAO.save(report);
    }

    @Override
    public List<Report> findAll() {
        return reportDAO.findAll();
    }

    @Override
    public List<Report> findByUserId(int id) {
        return reportDAO.findByUserId(id);
    }

    @Override
    public Report findById(int id) {
        return reportDAO.findById(id);
    }
}
