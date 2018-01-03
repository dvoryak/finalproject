package dao.factory;

import dao.ClientDAO;
import dao.InspectorDAO;
import dao.ReportDAO;

import java.sql.Connection;

public abstract class AbstractDAOFactory {

    public abstract ClientDAO createUserDAO(Connection connection);

    public abstract InspectorDAO createInspectorDAO(Connection connection);

    public abstract ReportDAO createReportDAO(Connection connection);

}
