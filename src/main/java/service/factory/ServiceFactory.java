package service.factory;


import service.InspectorService;
import service.ReportService;
import service.ClientService;

public abstract class ServiceFactory {

    public abstract ClientService createClientService();

    public abstract InspectorService createInspectorService();

    public abstract ReportService createReportService();

}
