package service;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 *
 */
public abstract class ServiceFactory {

    /**
     * Create ClientService
     *
     * @return {@link ClientService}
     */
    public abstract ClientService createClientService();

    /**
     * Create InspectorService
     *
     * @return {@link InspectorService}
     */
    public abstract InspectorService createInspectorService();

    /**
     * Create ReportService
     *
     * @return {@link ReportService}
     */
    public abstract ReportService createReportService();

    /**
     * Create UserRequestService
     *
     * @return {@link UserRequestService}
     */
    public abstract UserRequestService createUserRequestService();

}
