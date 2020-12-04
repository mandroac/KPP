package com.company;

import java.util.Arrays;
import java.util.List;

public class TreadmillCrossfitSimulator extends CrossfitSimulator{

    public static final int MAX_INCLINE = 30, MIN_INCLINE = 0;
    public static final List<MuscleType> MuscleTypes = Arrays.asList(new MuscleType[]{MuscleType.Cardio, MuscleType.Abdominis});

    private int incline;

    public TreadmillCrossfitSimulator(double price, int usdPerDay, int incline) {
        this.price = price;
        this.usedPerDay = usdPerDay;

        if(incline > MAX_INCLINE) this.incline = MAX_INCLINE;
        else this.incline = Math.max(incline, MIN_INCLINE);
    }


    @Override
    public List<MuscleType> getMuscleTypes() {
        return TreadmillCrossfitSimulator.MuscleTypes;
    }

    @Override
    public String work() {
        return "We are running!";
    }

    public int getIncline() {
        return incline;
    }

    @Override
    public String toString() {
        return "TreadmillCrossfitSimulator{" +
                "incline=" + incline +
                ", price=" + price +
                ", usedPerDay=" + usedPerDay +
                '}';
    }

    public void setIncline(int incline){
        this.incline = incline;
    }
}
