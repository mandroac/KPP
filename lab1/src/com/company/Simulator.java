package com.company;

import java.util.List;

public abstract class Simulator {

    protected double price;
    protected int usedPerDay;

    public abstract List<MuscleType> getMuscleTypes();
    public abstract String work();
}
