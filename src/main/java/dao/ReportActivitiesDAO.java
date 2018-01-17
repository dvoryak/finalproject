package dao;

import model.entity.ReportActivities;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author paveldvoryak
 * @version 1.0
 */

public interface ReportActivitiesDAO {

    /**
     * Find activity from report by id
     * @param reportId
     * @return {@link ReportActivitiesDAO}
     * @throws SQLException
     */
    List<ReportActivities> findByReportId(int reportId) throws SQLException;


    /**
     * Save activities
     *
     * @param connection
     * @param reportActivities
     * @return TRUE if operation was successful otherwise FALSE
     * @throws SQLException
     */
    boolean save(Connection connection, ReportActivities... reportActivities) throws SQLException;


    /**
     * Update activities
     *
     * @param connection
     * @param reportActivities
     * @return TRUE if operation was successful otherwise FALSE
     * @throws SQLException
     */
    boolean update(Connection connection, ReportActivities... reportActivities) throws SQLException;

}
