package com.company;

import java.util.Arrays;
import java.util.List;

public class ButterflySimulator extends PowerSimulator{

    public static final List<MuscleType> MuscleTypes = Arrays.asList(new MuscleType[]{ MuscleType.Chest, MuscleType.Back});

    @Override
    public String toString() {
        return "ButterflySimulator{" +
                "currentState=" + currentState +
                ", price=" + price +
                ", usedPerDay=" + usedPerDay +
                '}';
    }

    public ButterflySimulator(double price, int usdPerDay) {
        this.price = price;
        this.usedPerDay = usdPerDay;
        this.currentState = MuscleType.Chest;
    }


    @Override
    public List<MuscleType> getMuscleTypes() {
        return ButterflySimulator.MuscleTypes;
    }

    @Override
    public String work() {
        return switch (currentState) {
            case Chest -> "Shaping a chest";
            case Back -> "Exercising back";
            default -> "Warming up";
        };
    }

    public MuscleType getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(MuscleType currentState){
        this.currentState = currentState;
    }
}
