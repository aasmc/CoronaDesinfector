package ru.aasmc;

import ru.aasmc.context.Application;
import ru.aasmc.context.ApplicationContext;
import ru.aasmc.model.CoronaDesinfector;
import ru.aasmc.model.Room;
import ru.aasmc.model.police.Policeman;
import ru.aasmc.model.police.PolicemanImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.aasmc", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDesinfector coronaDesinfector = context.getObject(CoronaDesinfector.class);
        coronaDesinfector.start(new Room());
    }
}
