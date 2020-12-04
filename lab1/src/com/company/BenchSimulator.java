package com.company;

import java.util.Arrays;
import java.util.List;

public class BenchSimulator extends PowerSimulator{

    public static final List<MuscleType> MuscleTypes =
            Arrays.asList(new MuscleType[]{MuscleType.Chest, MuscleType.Biceps, MuscleType.Triceps, MuscleType.Forearm, MuscleType.Shoulders});

    private Barbell barbell;

    public BenchSimulator(double price, int usdPerDay, double weight) {
        this.barbell = new Barbell();
        this.barbell.setWeight(weight);
        this.price = price;
        this.usedPerDay = usdPerDay;
        this.currentState = MuscleType.Chest;
    }

    private class Barbell{
        private final static double barbellWeight = 20;
        private double additionalWeight;

        public double getWeight() {
            return barbellWeight + additionalWeight;
        }

        public void setWeight(double additionalWeight) {
            this.additionalWeight = additionalWeight;
        }
    }

    @Override
    public String toString() {
        return "BenchSimulator{" +
                "currentState=" + currentState +
                ", price=" + price +
                ", usedPerDay=" + usedPerDay +
                '}';
    }

    @Override
    public List<MuscleType> getMuscleTypes() {
        return BenchSimulator.MuscleTypes;
    }

    @Override
    public String work() {
        return switch (currentState) {
            case Biceps -> "Working on biceps";
            case Triceps -> "Working on triceps";
            case Forearm -> "Destroying forearm";
            case Chest -> "Pumping up a chest";
            case Shoulders -> "Exercising shoulders";
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
