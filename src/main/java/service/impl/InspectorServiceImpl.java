package service.impl;

import dao.InspectorDAO;
import model.entity.Inspector;
import service.InspectorService;

import java.sql.SQLException;
import java.util.List;

public class InspectorServiceImpl implements InspectorService {

    private InspectorDAO inspectorDAO;

    public InspectorServiceImpl(InspectorDAO inspectorDAO) {
        this.inspectorDAO = inspectorDAO;
    }

    @Override
    public Inspector findByLogin(String login) throws SQLException {
        return inspectorDAO.findByLogin(login);
    }

    @Override
    public List<Inspector> findAll() throws SQLException {
        return inspectorDAO.findAll();
    }

    @Override
    public boolean save(Inspector inspector) throws SQLException {
        return inspectorDAO.save(inspector);
    }

    @Override
    public Inspector findById(int id) throws SQLException {
        return inspectorDAO.findById(id);
    }
}
