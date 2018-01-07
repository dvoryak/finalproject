package dao.mysqlDaoImpl;

import dao.ClientDAO;
import dao.InspectorDAO;
import dao.ReportDAO;
import dao.factory.AbstractDAOFactory;
import dao.pool.ConnectionPool;


public class MysqlDaoFactory extends AbstractDAOFactory {

    @Override
    public ClientDAO createClientDAO() {
        return new ClientDAOImpl();
    }

    @Override
    public InspectorDAO createInspectorDAO() {
        return null;
    }

    @Override
    public ReportDAO createReportDAO() {
        return null;
    }
}
