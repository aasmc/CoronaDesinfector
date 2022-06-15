package ru.aasmc.objectconfigurators;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object target, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {

            if (implClass.getInterfaces().length == 0) {
                return Enhancer.create(implClass, (InvocationHandler) (o, method, args) -> getInvocationHandlerLogic(target, method, args));
            }

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(target, method, args));
        } else {
            return target;
        }
    }

    private Object getInvocationHandlerLogic(Object target, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        if (method.isAnnotationPresent(Deprecated.class)) {
            System.out.println("*** You have called a method " + target.getClass().getSimpleName() + "." + method.getName() + "() that has been DEPRECATED! ***");
        }
        return method.invoke(target, args);
    }
}
