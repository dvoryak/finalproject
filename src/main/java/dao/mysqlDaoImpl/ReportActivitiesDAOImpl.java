package dao.mysqlDaoImpl;

import dao.ReportActivitiesDAO;
import dao.pool.ConnectionPool;
import model.entity.ReportActivities;

import java.sql.*;
import java.util.*;

public class ReportActivitiesDAOImpl implements ReportActivitiesDAO {

    private ConnectionPool pool = ConnectionPool.INSTANCE;
    private ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");

    @Override
    public List<ReportActivities> findByReportId(int reportId) {
        try (Connection connection = pool.getConnection();
             Statement statement = connection.createStatement()) {
            List<ReportActivities> activities = new ArrayList<>();
            String q = bundle.getString("sql.activities.getByReportId").replace("?", Integer.toString(reportId));
            ResultSet rs = statement.executeQuery(q);

            while (rs.next()) {
                activities.add(new ReportActivities(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getString("name"),
                        rs.getInt("reportId")
                ));
            }

            return activities;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean save(Connection connection, ReportActivities... reportActivities) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.activities.save"))) {
            for (ReportActivities reportActivity : reportActivities) {
                ps.setString(1, reportActivity.getName());
                ps.setString(2, reportActivity.getText());
                ps.setInt(3, reportActivity.getReportId());
                ps.execute();
            }
            return true;
        }
    }

    @Override
    public boolean update(Connection connection, ReportActivities... reportActivity) throws SQLException {
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.activities.update"))) {
            for (ReportActivities activity : reportActivity) {
                ps.setString(1, activity.getName());
                ps.setString(2, activity.getText());
                ps.setInt(3, activity.getReportId());
                ps.executeUpdate();
            }
            return true;
        }
    }
}
