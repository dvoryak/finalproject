package service.impl;

import dao.InspectorDAO;
import model.entity.Inspector;
import service.InspectorService;

import java.util.List;

public class InspectorServiceImpl implements InspectorService {

    private InspectorDAO inspectorDAO;

    public InspectorServiceImpl(InspectorDAO inspectorDAO) {
        this.inspectorDAO = inspectorDAO;
    }

    @Override
    public Inspector findByLogin(String login) {
        return inspectorDAO.findByLogin(login);
    }

    @Override
    public List<Inspector> findAll() {
        return inspectorDAO.findAll();
    }

    @Override
    public boolean save(Inspector inspector) {
        return inspectorDAO.save(inspector);
    }

    @Override
    public Inspector findById(int id) {
        return inspectorDAO.findById(id);
    }
}
