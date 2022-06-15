package ru.aasmc.announcer;

import ru.aasmc.annotations.InjectByType;
import ru.aasmc.recommendations.Recommendator;

public class ConsoleAnnouncer implements Announcer {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
