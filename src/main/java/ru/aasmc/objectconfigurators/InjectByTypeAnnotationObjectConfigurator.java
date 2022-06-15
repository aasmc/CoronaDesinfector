package ru.aasmc.objectconfigurators;

import lombok.SneakyThrows;
import ru.aasmc.annotations.InjectByType;
import ru.aasmc.context.ApplicationContext;
import ru.aasmc.objectcreators.ObjectFactory;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {

    @SneakyThrows
    @Override
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
