package dao.mysqlDaoImpl;

import dao.*;
import dao.mysqlDaoImpl.ClientDAOImpl;
import dao.mysqlDaoImpl.InspectorDAOImpl;
import dao.mysqlDaoImpl.ReportDAOImpl;
import dao.mysqlDaoImpl.UserRequestDAOImpl;
import dao.pool.ConnectionPool;


public class MysqlDaoFactory extends DAOFactory {

    @Override
    public ReportDAO createReportDAO() {
        return new ReportDAOImpl();
    }

    @Override
    public ClientDAO createClientDAO() {
        return new ClientDAOImpl(ConnectionPool.getInstance());
    }

    @Override
    public InspectorDAO createInspectorDAO() {
        return new InspectorDAOImpl();
    }

    @Override
    public UserRequestDAO createUserRequestDAO() {
        return new UserRequestDAOImpl();
    }

    @Override
    public ReportPayerDAO createReportPayerDAO() {
        return new ReportPayerDAOImpl();
    }

    @Override
    public ReportActivitiesDAO createReportActivitiesDAO() {
        return new ReportActivitiesDAOImpl();
    }
}
