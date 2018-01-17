package service.impl;

import dao.mysqlDaoImpl.MysqlDaoFactory;
import service.InspectorService;
import service.ReportService;
import service.ClientService;
import service.UserRequestService;
import service.ServiceFactory;


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
        return new ReportServiceImpl(new MysqlDaoFactory().createReportDAO());
    }

    @Override
    public UserRequestService createUserRequestService() {
        return new UserRequestServiceImpl(new MysqlDaoFactory().createUserRequestDAO());
    }
}
