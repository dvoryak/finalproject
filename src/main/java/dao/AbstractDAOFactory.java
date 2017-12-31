package dao;

import java.sql.Connection;

public abstract class AbstractDAOFactory {

    public abstract UserDAO createUserDAO(Connection connection);

    public abstract InspectorDAO createInspectorDAO(Connection connection);

    public abstract ReportDAO createReportDAO(Connection connection);

}
