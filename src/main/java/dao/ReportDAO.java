package dao;

import model.entity.Report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */

public interface ReportDAO {

    /**
     * Update a report
     *
     * @param report - {@link Report}
     * @param connection - {@link Connection}
     * @return TRUE if operation was successful otherwise FALSE
     * @throws SQLException
     */
    boolean update(Report report, Connection connection) throws SQLException;

    /**
     * Save a report
     *
     * @param report - {@link Report}
     * @param connection - {@link Connection}
     * @return TRUE if operation was successful otherwise FALSE
     * @throws SQLException
     */
    boolean save(Report report, Connection connection) throws SQLException;

    /**
     * Find all reports
     *
     * @return {@link List<Report>}
     * @throws SQLException
     */
    List<Report> findAll() throws SQLException;


    /**
     * Find all reports by user's id
     *
     * @param id
     * @return {@link List<Report>}
     * @throws SQLException
     */
    List<Report> findByUserId(int id) throws SQLException;

    /**
     * Find all reports by inspector's id
     *
     * @param id
     * @return {@link List<Report>}
     * @throws SQLException
     */
    List<Report> findByInspectorId(int id) throws SQLException;


    /**
     * Find by report's id
     *
     * @param id
     * @return {@link Report}
     * @throws SQLException
     */
    Report findById(int id) throws SQLException;
}
