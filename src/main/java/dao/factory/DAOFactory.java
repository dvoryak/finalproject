package dao.factory;

import dao.ClientDAO;
import dao.InspectorDAO;
import dao.ReportDAO;

public abstract class DAOFactory {

    public abstract ReportDAO createReportDAO();

    public abstract ClientDAO createClientDAO();

    public abstract InspectorDAO createInspectorDAO();


}
