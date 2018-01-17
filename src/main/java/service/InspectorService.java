package service;

import model.entity.Inspector;

import java.sql.SQLException;
import java.util.List;

/**
 * @author paveldvoryak
 * @version 1.0
 */
public interface InspectorService {

    /**
     * Find a inspector by Login
     * @param login - login of inspector
     * @return {@link Inspector}
     * @throws SQLException
     */
    Inspector findByLogin(String login) throws SQLException;


    /**
     * Find all inspectors in database
     * @return @{@link List} of {@link Inspector}
     * @throws SQLException
     */
    List<Inspector> findAll() throws SQLException;

    /**
     * Save inspector
     * @param inspector - {@link Inspector}
     * @return TRUE if operation was successful otherwise FALSE
     * @throws SQLException
     */
    boolean save(Inspector inspector) throws SQLException;


    /**
     * Find by inspector's id
     * @param id
     * @return {@link Inspector}
     * @throws SQLException
     */
    Inspector findById(int id) throws SQLException;
}
