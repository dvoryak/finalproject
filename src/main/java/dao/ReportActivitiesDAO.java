package dao;

import model.entity.ReportActivities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface ReportActivitiesDAO {

    List<ReportActivities> findByReportId(int reportId);

    boolean save(Connection connection, ReportActivities... reportActivities) throws SQLException;

    boolean update(Connection connection, ReportActivities... reportActivity) throws SQLException;

}
