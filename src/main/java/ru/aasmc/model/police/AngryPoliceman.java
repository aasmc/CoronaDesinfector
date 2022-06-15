package ru.aasmc.model.police;

public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("I'm an angry policeman. Go out!");
    }
}
