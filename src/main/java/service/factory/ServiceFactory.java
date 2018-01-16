package service.factory;


import service.InspectorService;
import service.ReportService;
import service.ClientService;
import service.UserRequestService;

public abstract class ServiceFactory {

    public abstract ClientService createClientService();

    public abstract InspectorService createInspectorService();

    public abstract ReportService createReportService();

    public abstract UserRequestService createUserRequestService();

}
