package service.factory;

import dao.factory.MysqlDaoFactory;
import service.InspectorService;
import service.ReportService;
import service.ClientService;
import service.impl.ClientServiceImpl;
import service.impl.InspectorServiceImpl;
import service.impl.ReportServiceImpl;


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

}
