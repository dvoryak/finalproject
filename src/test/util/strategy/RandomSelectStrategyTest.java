package util.strategy;

import model.entity.Inspector;
import org.junit.Test;
import org.mockito.Mockito;
import service.InspectorService;
import service.ServiceFactory;
import service.impl.InspectorServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RandomSelectStrategyTest {



    @Test
    public void test_get_inspector() throws SQLException {

        ServiceFactory serviceFactory = mock(ServiceFactory.class);

        InspectorServiceImpl inspectorService = mock(InspectorServiceImpl.class);

        RandomSelectStrategy randomSelectStrategy = new RandomSelectStrategy(serviceFactory);

        when(serviceFactory.createInspectorService())
                .thenReturn(inspectorService);

        when(inspectorService.findAll())
                .thenReturn(Arrays.asList(new Inspector(),new Inspector()));

        assertNotNull(randomSelectStrategy.getInspector());


    }

    @Test(expected = RuntimeException.class)
    public void test_get_inspector_ex() throws SQLException {

        ServiceFactory serviceFactory = mock(ServiceFactory.class);

        InspectorServiceImpl inspectorService = mock(InspectorServiceImpl.class);

        RandomSelectStrategy randomSelectStrategy = new RandomSelectStrategy(serviceFactory);

        when(serviceFactory.createInspectorService())
                .thenReturn(inspectorService);

        when(inspectorService.findAll())
                .thenReturn(Arrays.asList());


        randomSelectStrategy.getInspector();


    }



}