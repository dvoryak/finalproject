package service;


public abstract class AbstractServiceFactory {

    public abstract InspectorService createInspectorService();

    public abstract ClientService createClientService();

    public abstract ReportService createReportService();

}
