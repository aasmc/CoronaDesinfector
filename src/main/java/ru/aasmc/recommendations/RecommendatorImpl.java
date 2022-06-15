package ru.aasmc.recommendations;

import ru.aasmc.annotations.InjectProperty;
import ru.aasmc.annotations.Singleton;

@Singleton
public class RecommendatorImpl implements Recommendator {

    public RecommendatorImpl() {
        System.out.println("Recommendator was created!");
    }

    @InjectProperty("whiskey")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("To protect from COVID-19 Drink " + alcohol);
    }
}
