package dao.factory;

import dao.ClientDAO;
import dao.InspectorDAO;
import dao.ReportDAO;
import dao.UserRequestDAO;

public abstract class DAOFactory {

    public abstract ReportDAO createReportDAO();

    public abstract ClientDAO createClientDAO();

    public abstract InspectorDAO createInspectorDAO();

    public abstract UserRequestDAO createUserRequestDAO();


}
