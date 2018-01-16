package util;

import model.entity.Inspector;
import model.entity.Report;
import service.InspectorService;
import service.ReportService;
import service.factory.ServiceFactory;
import service.factory.ServiceFactoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomSelectStrategy implements InspectorSelectStrategy {

    private ServiceFactory serviceFactory;

    public RandomSelectStrategy(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public Inspector getInspector() {
        InspectorService inspectorService = serviceFactory.createInspectorService();

        List<Inspector> inspectors = inspectorService.findAll();

        int size = inspectors.size();

        int i = new Random().nextInt(size);

        return inspectors.get(i);
    }


}
