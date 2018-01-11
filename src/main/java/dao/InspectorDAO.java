package dao;

import model.entity.Inspector;

import java.util.List;

public interface InspectorDAO {

    Inspector findByLogin(String login);

    List<Inspector> findAll();

    boolean save(Inspector inspector);

}
