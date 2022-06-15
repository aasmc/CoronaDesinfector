package ru.aasmc.context;

import lombok.Getter;
import lombok.Setter;
import ru.aasmc.annotations.Singleton;
import ru.aasmc.configs.Config;
import ru.aasmc.objectcreators.ObjectFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    @Setter
    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();
    @Getter
    private Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type) {
        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T object = factory.createObject(implClass);
        if (implClass.isAnnotationPresent(Singleton.class)) {
            cache.put(type, object);
        }
        return object;
    }
}
