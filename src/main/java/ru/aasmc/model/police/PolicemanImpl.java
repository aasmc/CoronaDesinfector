package ru.aasmc.model.police;

import ru.aasmc.annotations.InjectByType;
import ru.aasmc.recommendations.Recommendator;

import javax.annotation.PostConstruct;

public class PolicemanImpl implements Policeman {
    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Go out of the room! I'm a policeman!");
    }
}
