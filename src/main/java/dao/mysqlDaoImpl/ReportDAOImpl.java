package dao.mysqlDaoImpl;

import dao.ReportDAO;
import dao.pool.ConnectionPool;
import model.entity.Report;
import model.entity.ReportActivities;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

/**
 * MySQL implementation of @{@link ReportDAO}
 *
 * @author paveldvoryak
 * @version 1.0
 */

public class ReportDAOImpl implements ReportDAO {

    private ConnectionPool pool = ConnectionPool.INSTANCE;
    private ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");
    private final static Logger logger = Logger.getLogger(ReportDAOImpl.class);


    @Override
    public boolean update(Report report, Connection connection) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.report.update"))) {

            ps.setString(1, report.getInstitute());
            ps.setInt(2, report.getEmployeeNumber());
            ps.setDate(3, report.getDate());
            ps.setString(4, report.getMessage());
            ps.setInt(5, report.getStatus().getId());
            ps.setInt(6, report.getId());
            return ps.execute();

        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }
    }

    @Override
    public boolean save(Report report, Connection connection) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.report.save"))) {
            ps.setInt(1, report.getId());
            ps.setString(2, report.getInstitute());
            ps.setInt(3, report.getEmployeeNumber());
            ps.setDate(4, report.getDate());
            ps.setString(5, report.getMessage());
            ps.setInt(6, report.getStatus().getId());
            ps.setInt(7, report.getPayer().getId());
            ps.setInt(8, report.getClient().getId());
            ps.setInt(9, report.getInspector().getId());
            return ps.execute();
        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }

    }

    @Override
    public List<Report> findAll() throws SQLException {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = pool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(bundle.getString("sql.report.findAll"));

            while (rs.next()) {
                reports.add(getEntity(rs));
            }

            return reports;

        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }

    }

    @Override
    public List<Report> findByUserId(int id) throws SQLException {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.report.findByUser"))) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                reports.add(getEntity(rs));
            }

            return reports;

        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }

    }

    @Override
    public Report findById(int id) throws SQLException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.report.findById"))) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return getEntity(rs);
            }

        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }

        return null;
    }

    @Override
    public List<Report> findByInspectorId(int id) throws SQLException {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.report.findByInspector"))) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                reports.add(getEntity(rs));
            }

            return reports;

        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }
    }

    private Report getEntity(ResultSet rs) throws SQLException {
        return new Report.Builder()
                .id(rs.getInt("id"))
                .institute(rs.getString("institution"))
                .employeeNumber(rs.getInt("employeesNumber"))
                .date(rs.getDate("data"))
                .message(rs.getString("message"))
                .status(Report.Status.values()[rs.getInt("statusId") - 1])
                .client(new ClientDAOImpl().findById(rs.getInt("userId")))
                .payer(new ReportPayerDAOImpl().findById(rs.getInt("payerId")))
                .inspector(new InspectorDAOImpl().findById(rs.getInt("inspector_id")))
                .activities(new ReportActivitiesDAOImpl().findByReportId(rs.getInt("id")))
                .build();
    }

}
