package service;

import java.sql.Connection;

public abstract class AbstractServiceFactory {

    public abstract InspectorService createInspectorService(Connection connection);

    public abstract ClientService createUserService(Connection connection);

    public abstract ReportService createReportService(Connection connection);

}
