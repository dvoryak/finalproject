package dao;

import model.entity.ReportPayer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */

public interface ReportPayerDAO {

    /**
     * Find payer from report by id
     *
     * @param reportId
     * @return {@link ReportPayer}
     * @throws SQLException
     */
    ReportPayer findById(int reportId) throws SQLException;

    /**
     * Update a payer from report
     *
     * @param reportPayer {@link ReportPayer}
     * @param connection {@link Connection}
     * @return TRUE if operation was successful otherwise FALSE
     * @throws SQLException
     */
    boolean update(ReportPayer reportPayer, Connection connection) throws SQLException;

    /**
     * Save a payer from report
     *
     * @param reportPayer {@link ReportPayer}
     * @param connection {@link Connection}
     * @return TRUE if operation was successful otherwise FALSE
     * @throws SQLException
     */
    boolean save(ReportPayer reportPayer, Connection connection) throws SQLException;
}
