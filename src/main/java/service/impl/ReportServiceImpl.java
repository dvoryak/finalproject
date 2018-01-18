package service.impl;

import dao.DAOFactory;
import dao.ReportActivitiesDAO;
import dao.ReportDAO;
import dao.ReportPayerDAO;
import dao.mysqlDaoImpl.ReportDAOImpl;
import model.entity.Report;
import model.entity.ReportActivities;
import service.ReportService;
import service.transaction.TransactionManager;

import java.sql.SQLException;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    private DAOFactory daoFactory;
    private TransactionManager transactionManager;

    public ReportServiceImpl(DAOFactory daoFactory, TransactionManager transactionManager) {
        this.daoFactory = daoFactory;
        this.transactionManager = transactionManager;
    }

    @Override
    public List<Report> findAll() throws SQLException {
        return daoFactory.createReportDAO().findAll();
    }

    @Override
    public List<Report> findByUserId(int id) throws SQLException {
        return daoFactory.createReportDAO().findByUserId(id);
    }

    @Override
    public Report findById(int id) throws SQLException {
        return daoFactory.createReportDAO().findById(id);
    }

    @Override
    public boolean update(Report report) throws SQLException {
        return transactionManager.processTransaction(connection -> {
            daoFactory.createReportDAO().update(report,connection);
            daoFactory.createReportPayerDAO().update(report.getPayer(),connection);
            daoFactory.createReportActivitiesDAO().update(connection,report.getActivities().toArray(new ReportActivities[]{}));
            return true;
        });
    }

    @Override
    public List<Report> findByInspectorId(int id) throws SQLException {
        return daoFactory.createReportDAO().findByInspectorId(id);
    }

    public boolean save(Report report) throws SQLException {
        return transactionManager.processTransaction(connection -> {
            ReportPayerDAO reportPayerDAO = daoFactory.createReportPayerDAO();
            reportPayerDAO.save(report.getPayer(),connection);

            ReportDAO reportDAO = daoFactory.createReportDAO();
            reportDAO.save(report,connection);

            ReportActivitiesDAO reportActivitiesDAO = daoFactory.createReportActivitiesDAO();
            reportActivitiesDAO.save(connection,report.getActivities().toArray(new ReportActivities[]{}));

            return true;
        });
    }
}
