package service.impl;

import service.AbstractServiceFactory;
import service.InspectorService;
import service.ReportService;
import service.ClientService;

import java.sql.Connection;

public class ServiceFactoryImpl extends AbstractServiceFactory {
    @Override
    public InspectorService createInspectorService(Connection connection) {
        return null;
    }

    @Override
    public ClientService createUserService(Connection connection) {
        return new ClientServiceImpl();
    }

    @Override
    public ReportService createReportService(Connection connection) {
        return null;
    }
}
