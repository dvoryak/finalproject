package dao;

import model.entity.ReportActivities;

import java.util.List;

public interface ReportActivitiesDAO {

    List<ReportActivities> findById(long reportID);

}
