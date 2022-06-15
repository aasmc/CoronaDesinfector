package ru.aasmc.model;

import ru.aasmc.annotations.InjectByType;
import ru.aasmc.announcer.Announcer;
import ru.aasmc.model.police.Policeman;

@Deprecated
public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    @Deprecated
    public void start(Room room) {
        announcer.announce("Beginning disinfection. All out!");
        policeman.makePeopleLeaveRoom();
        disinfect(room);
        announcer.announce("You can come in.");

    }

    private void disinfect(Room room) {
        System.out.println("Performing disinfection of the room");
    }
}
