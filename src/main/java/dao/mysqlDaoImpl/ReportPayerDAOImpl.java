package dao.mysqlDaoImpl;

import dao.ClientDAO;
import dao.ReportPayerDAO;
import dao.pool.ConnectionPool;
import model.entity.ReportPayer;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;


/**
 * MySQL implementation of @{@link ReportPayerDAO}
 *
 * @author paveldvoryak
 * @version 1.0
 */

public class ReportPayerDAOImpl implements ReportPayerDAO {

    private ConnectionPool pool = ConnectionPool.getInstance();
    private ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");
    private final Logger logger = Logger.getLogger(ReportDAOImpl.class);

    public ReportPayerDAOImpl() {
    }

    public ReportPayerDAOImpl(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public ReportPayer findById(int id) throws SQLException {
        try(Connection connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.payer.findById"))) {
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                ReportPayer entity = getEntity(rs);
                return entity;
            }
        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }

        return null;
    }


    @Override
    public boolean update(ReportPayer reportPayer, Connection connection) throws SQLException {
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.payer.update"))) {
            ps.setString(1,reportPayer.getFirstName());
            ps.setString(2,reportPayer.getLastName());
            ps.setString(3,reportPayer.getMiddleName());
            ps.setString(4,reportPayer.getPassport());
            ps.setString(5,reportPayer.getPhone());
            ps.setString(6,reportPayer.getCity());
            ps.setString(7,reportPayer.getStreet());
            ps.setString(8,reportPayer.getHome());
            ps.setInt(9,reportPayer.getId());

            return ps.execute();

        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }
    }

    @Override
    public boolean save(ReportPayer reportPayer, Connection connection) throws SQLException {
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.payer.save"))) {
            ps.setInt(1,reportPayer.hashCode());
            ps.setString(2,reportPayer.getFirstName());
            ps.setString(3,reportPayer.getLastName());
            ps.setString(4,reportPayer.getMiddleName());
            ps.setString(5,reportPayer.getPassport());
            ps.setString(6,reportPayer.getPhone());
            ps.setString(7,reportPayer.getCity());
            ps.setString(8,reportPayer.getStreet());
            ps.setString(9,reportPayer.getHome());

            return ps.execute();

        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }

    }

    private ReportPayer getEntity(ResultSet rs) throws SQLException {
        return new ReportPayer.Builder()
                .id(rs.getInt("id")) // ?
                .firstName(rs.getString("firstName"))
                .lastName(rs.getString("lastName"))
                .middleName(rs.getString("middleName"))
                .passport(rs.getString("passport"))
                .phone(rs.getString("phone"))
                .city(rs.getString("city"))
                .street(rs.getString("street"))
                .home(rs.getString("home"))
                .build();
    }
}
