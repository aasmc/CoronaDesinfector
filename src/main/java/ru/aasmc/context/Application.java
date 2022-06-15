package ru.aasmc.context;

import ru.aasmc.configs.JavaConfig;
import ru.aasmc.objectcreators.ObjectFactory;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packagesToScan, Map<Class, Class> ifcToImplClass) {
        JavaConfig config = new JavaConfig(packagesToScan, ifcToImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        // TODO init all not lazy singletons
        context.setFactory(objectFactory);
        return context;
    }
}
