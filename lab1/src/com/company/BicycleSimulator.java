package com.company;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class BicycleSimulator extends  CrossfitSimulator{

    public static final List<MuscleType> MuscleTypes =
            Arrays.asList( new MuscleType[] {MuscleType.Cardio, MuscleType.Hip, MuscleType.Gastrocnemius});

    public static final int MAX_DIFFICULTY = 10, MIN_DIFFICULTY = 0;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    private int difficulty;

    @Override
    public String toString() {
        return "BicycleSimulator{" +
                "difficulty=" + difficulty +
                ", price=" + price +
                ", usedPerDay=" + usedPerDay +
                '}';
    }

    public BicycleSimulator(double price, int usdPerDay, int difficulty) {
        this.price = price;
        this.usedPerDay = usdPerDay;

        if(difficulty > MAX_DIFFICULTY) this.difficulty = MAX_DIFFICULTY;
        else this.difficulty = Math.max(difficulty, MIN_DIFFICULTY);
    }

    @Override
    public List<MuscleType> getMuscleTypes() {
        return BicycleSimulator.MuscleTypes;
    }

    @Override
    public String work() {
        return "We are riding!";
    }
}
