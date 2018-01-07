package dao;

import model.entity.ReportStatus;

public interface ReportStatusDAO {

    ReportStatus findById(long statusID);
}
