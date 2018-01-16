package service;

import model.entity.Inspector;

import java.util.List;

public interface InspectorService {

    Inspector findByLogin(String login);

    List<Inspector> findAll();

    boolean save(Inspector inspector);

    Inspector findById(int id);
}
