package com.company;

public class Exercise {
    private String Name;
    private MuscleType Muscle;


    public Exercise(String name, MuscleType muscle) {
        Name = name;
        Muscle = muscle;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setMuscle(MuscleType muscle) {
        Muscle = muscle;
    }


    public String getName() {
        return Name;
    }

    public MuscleType getMuscle() {
        return Muscle;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "Name='" + Name + '\'' +
                ", Muscle=" + Muscle +
                '}';
    }
}
