package com.company;

import java.util.*;

public class GymManager {
    private List<Simulator> simulatorList;
    private List<Exercise> exerciseProgramList;

    public List<Exercise> getExerciseProgramList() {
        return exerciseProgramList;
    }


    public List<Simulator> getSimulatorList() {
        return simulatorList;
    }

    public GymManager(List<Simulator> simulatorList, List<Exercise> exerciseProgramList) {

        this.simulatorList = simulatorList;
        this.exerciseProgramList = exerciseProgramList;
    }

    public GymManager() {

        this.simulatorList = new ArrayList<>();
        this.exerciseProgramList = new ArrayList<>();
    }

    public void AddSimulator(Simulator simulator) {
        simulatorList.add(simulator);
    }

    public void showSimulators(){

        for (var sim: simulatorList
             ) {
            System.out.println(sim);
        }
    }

    public void AddExercise(Exercise exercise) {
        exerciseProgramList.add(exercise);
    }

    public void showProgram(){

        for (var exe: exerciseProgramList
        ) {
            System.out.println(exe);
        }
    }

    public void ProgramSimulatorsSearch()
    {
        for (var exe: exerciseProgramList
             ) {
            for (var sim: simulatorList
                 ) {
                if (sim.getMuscleTypes().contains(exe.getMuscle()))
                    System.out.println(
                            exe.getName() + " - " + sim.toString()
                    );
            }
        }
    }

    public static class SimulatorsSortManager{

        public static void sortByPriceAsc(List<Simulator> simulatorList) {

            Collections.sort(simulatorList, new Comparator<Simulator>() {
                @Override
                public int compare(Simulator o1, Simulator o2) {
                    return Double.compare(o1.price, o2.price);
                }
            });

        }

        public static void sortByPriceDesc (List <Simulator> simulatorList) {

            Collections.sort(simulatorList, new Comparator<Simulator>() {
                @Override
                public int compare(Simulator o1, Simulator o2) {
                    return Double.compare(o2.price, o1.price);
                }
            });
        }

        public static void sortByUsgPerDayAsc (List <Simulator> simulatorList) {

            simulatorList.sort( (s1, s2) -> Double.compare(s1.usedPerDay, s2.usedPerDay));
        }

        public static void sortByUsgPerDayDesc (List <Simulator> simulatorList) {

            simulatorList.sort( (s1, s2) -> Double.compare(s2.usedPerDay, s1.usedPerDay));
        }

    }


}
