package ru.aasmc.objectconfigurators;

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object target, Class implClass);
}
