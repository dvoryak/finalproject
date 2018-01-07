package dao.factory;

import dao.ClientDAO;
import dao.InspectorDAO;
import dao.ReportDAO;
import dao.pool.ConnectionPool;

import java.sql.Connection;

public abstract class AbstractDAOFactory {

    public abstract ClientDAO createClientDAO();

    public abstract InspectorDAO createInspectorDAO();

    public abstract ReportDAO createReportDAO();

}
