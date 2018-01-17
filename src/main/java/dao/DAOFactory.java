package dao;

/**
 * Abstract factory for creation a dao-entity
 */
public abstract class DAOFactory {

    /**
     * Create ReportDAO
     * @return {@link ReportDAO}
     */
    public abstract ReportDAO createReportDAO();

    /**
     * Create ClientDAO
     * @return {@link ClientDAO}
     */
    public abstract ClientDAO createClientDAO();

    /**
     * Create InspectorDAO
     * @return {@link InspectorDAO}
     */
    public abstract InspectorDAO createInspectorDAO();

    /**
     * Create UserRequestDAO
     * @return {@link UserRequestDAO}
     */
    public abstract UserRequestDAO createUserRequestDAO();


}
