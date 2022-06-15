package ru.aasmc.objectconfigurators;

import ru.aasmc.context.ApplicationContext;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
