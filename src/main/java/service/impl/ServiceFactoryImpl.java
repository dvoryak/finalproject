package service.impl;

import dao.mysqlDaoImpl.MysqlDaoFactory;
import dao.pool.ConnectionPool;
import service.InspectorService;
import service.ReportService;
import service.ClientService;
import service.UserRequestService;
import service.ServiceFactory;
import service.transaction.TransactionManagerImpl;


public class ServiceFactoryImpl extends ServiceFactory {

    @Override
    public ClientService createClientService() {
        return new ClientServiceImpl(new MysqlDaoFactory().createClientDAO());
    }

    @Override
    public InspectorService createInspectorService() {
        return new InspectorServiceImpl(new MysqlDaoFactory().createInspectorDAO());
    }

    @Override
    public ReportService createReportService() {
        return new ReportServiceImpl(new MysqlDaoFactory(), new TransactionManagerImpl(ConnectionPool.getInstance()));
    }

    @Override
    public UserRequestService createUserRequestService() {
        return new UserRequestServiceImpl(new MysqlDaoFactory().createUserRequestDAO());
    }
}
