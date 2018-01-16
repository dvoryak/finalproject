package dao.factory;

import dao.ClientDAO;
import dao.InspectorDAO;
import dao.ReportDAO;
import dao.UserRequestDAO;
import dao.mysqlDaoImpl.ClientDAOImpl;
import dao.mysqlDaoImpl.InspectorDAOImpl;
import dao.mysqlDaoImpl.ReportDAOImpl;
import dao.mysqlDaoImpl.UserRequestDAOImpl;


public class MysqlDaoFactory extends DAOFactory {

    @Override
    public ReportDAO createReportDAO() {
        return new ReportDAOImpl();
    }

    @Override
    public ClientDAO createClientDAO() {
        return new ClientDAOImpl();
    }

    @Override
    public InspectorDAO createInspectorDAO() {
        return new InspectorDAOImpl();
    }

    @Override
    public UserRequestDAO createUserRequestDAO() {
        return new UserRequestDAOImpl();
    }
}
