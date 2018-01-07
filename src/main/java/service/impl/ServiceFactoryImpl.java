package service.impl;

import dao.factory.AbstractDAOFactory;
import dao.mysqlDaoImpl.MysqlDaoFactory;
import dao.pool.ConnectionPool;
import service.AbstractServiceFactory;
import service.InspectorService;
import service.ReportService;
import service.ClientService;

import java.sql.Connection;

public class ServiceFactoryImpl extends AbstractServiceFactory {

    @Override
    public InspectorService createInspectorService() {
        return null;
    }

    @Override
    public ClientService createClientService() {
        return new ClientServiceImpl(new MysqlDaoFactory().createClientDAO());
    }

    @Override
    public ReportService createReportService() {
        return null;
    }
}
