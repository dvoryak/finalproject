package dao;

import model.entity.ReportPayer;

public interface PayerDAO {

    ReportPayer findById(long reportID);

}
