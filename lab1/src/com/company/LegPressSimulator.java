package com.company;

import java.util.Arrays;
import java.util.List;

public class LegPressSimulator extends PowerSimulator{

    public static final List<MuscleType> MuscleTypes =
            Arrays.asList(new MuscleType[]{ MuscleType.Hip, MuscleType.Gastrocnemius});


    public LegPressSimulator(double price, int usdPerDay) {
        this.price = price;
        this.usedPerDay = usdPerDay;
        this.currentState = MuscleType.Hip;
    }

    @Override
    public List<MuscleType> getMuscleTypes() {
        return LegPressSimulator.MuscleTypes;
    }

    @Override
    public String work() {
        return switch (currentState) {
            case Hip -> "Making long amplitude pushes";
            case Gastrocnemius -> "Making short amplitude pushes";
            default -> "Warming up";
        };
    }

    public MuscleType getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(MuscleType currentState){
        this.currentState = currentState;
    }

    @Override
    public String toString() {
        return "LegPressSimulator{" +
                "currentState=" + currentState +
                ", price=" + price +
                ", usedPerDay=" + usedPerDay +
                '}';
    }
}
