package util;

import model.entity.Inspector;
import service.InspectorService;
import service.ServiceFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * @author paveldvoryak
 * @version 1.0
 */
public class RandomSelectStrategy implements InspectorSelectStrategy {

    private ServiceFactory serviceFactory;

    public RandomSelectStrategy(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public Inspector getInspector() throws SQLException {
        InspectorService inspectorService = serviceFactory.createInspectorService();

        List<Inspector> inspectors = inspectorService.findAll();

        int size = inspectors.size();

        int i = new Random().nextInt(size);

        return inspectors.get(i);
    }


}
