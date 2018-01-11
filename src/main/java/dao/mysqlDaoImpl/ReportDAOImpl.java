package dao.mysqlDaoImpl;

import dao.ReportDAO;
import dao.pool.ConnectionPool;
import model.entity.Report;
import model.entity.ReportActivities;
import model.entity.ReportPayer;

import java.sql.*;
import java.util.*;

public class ReportDAOImpl implements ReportDAO {

    private ConnectionPool pool = ConnectionPool.INSTANCE;
    private ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");

    @Override
    public boolean save(Report report) {
        try(Connection connection = pool.getConnection()) {

            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.report.savePayer"));
            ps.setInt(1,report.getPayer().hashCode());
            ps.setString(2,report.getPayer().getFirstName());
            ps.setString(3,report.getPayer().getLastName());
            ps.setString(4,report.getPayer().getMiddleName());
            ps.setString(5,report.getPayer().getPassport());
            ps.setString(6,report.getPayer().getPhone());
            ps.setString(7,report.getPayer().getCity());
            ps.setString(8,report.getPayer().getStreet());
            ps.setString(9,report.getPayer().getHome());
            ps.execute();
            ps.close();

            ps = connection.prepareStatement(bundle.getString("sql.report.save"));
            ps.setInt(1,report.hashCode());
            ps.setString(2,report.getInstitute());
            ps.setInt(3,report.getEmployeeNumber());
            ps.setDate(4,report.getDate());
            ps.setString(5,report.getMessage());
            ps.setInt(6,report.getStatus().getId());
            ps.setInt(7,report.getPayer().hashCode());
            ps.setInt(8,report.getClient().getId());
            ps.execute();
            ps.close();

            System.out.println(report);

            Set<ReportActivities> activities = report.getActivities();
            ps = connection.prepareStatement(bundle.getString("sql.report.saveActivities"));
            for(ReportActivities activity : activities) {
                ps.setString(1, activity.getName());
                ps.setString(2, activity.getText());
                ps.setInt(3, report.hashCode());
                ps.execute();
            }
            ps.close();

            connection.commit();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public List<Report> findAll() {
        List<Report> reports = new ArrayList<>();
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(bundle.getString("sql.report.findAll"));

            while(rs.next()) {
                reports.add(getEntity(rs));
            }

            return reports;

        } catch (SQLException e) {
            e.printStackTrace();
            //TODO logger
        }

        return null;
    }

    @Override
    public List<Report> findByUserId(int id) {
        List<Report> reports = new ArrayList<>();
        try(Connection connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.report.findByUser"))) {
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                reports.add(getEntity(rs));
            }

            return reports;

        } catch (SQLException e) {
            e.printStackTrace();
            //TODO logger
        }

        return null;
    }

    @Override
    public Report findById(int id) {
        try(Connection connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.report.findById"))) {
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                return getEntity(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //TODO logger
        }

        return null;
    }

    private Report getEntity(ResultSet rs) throws SQLException {
        return new Report.Builder()
                .id(rs.getInt("id"))
                .institute(rs.getString("institution"))
                .employeeNumber(rs.getInt("employeesNumber"))
                .date(rs.getDate("data"))
                .status(Report.Status.values()[rs.getInt("statusId") - 1])
                .payer(new ReportPayer.Builder()
                        .id(rs.getInt("payerId")) // ?
                        .firstName(rs.getString("firstName"))
                        .lastName(rs.getString("lastName"))
                        .middleName(rs.getString("middleName"))
                        .passport(rs.getString("passport"))
                        .phone(rs.getString("phone"))
                        .city(rs.getString("city"))
                        .street(rs.getString("street"))
                        .home(rs.getString("home"))
                        .build())
                .activities(getActivites(rs.getInt("id")))
                .build();
    }

    private Set<ReportActivities> getActivites(int reportId) {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            Set<ReportActivities> activities = new HashSet<>();
            String q = bundle.getString("sql.activtity.getByReportId").replace("?",Integer.toString(reportId));
            ResultSet rs = statement.executeQuery(q);
            while(rs.next()) {
                activities.add(new ReportActivities(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getString("name")
                ));
            }

            return activities;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}
