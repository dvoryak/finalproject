package dao;

import model.entity.ReportPayer;

import java.sql.Connection;

public interface ReportPayerDAO {

    ReportPayer findById(int reportId);

    boolean update(ReportPayer reportPayer, Connection connection);

    boolean save(ReportPayer reportPayer, Connection connection);
}
