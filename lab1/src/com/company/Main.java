package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static <price> void main(String[] args) {
        var gymManager = new GymManager();
        gymManager.AddSimulator(new BenchSimulator(10000, 200, 10));
        gymManager.AddSimulator(new ButterflySimulator(17300, 55));
        gymManager.AddSimulator(new LegPressSimulator(15750.50, 70));
        gymManager.AddSimulator(new TreadmillCrossfitSimulator(25200, 50, 5));
        gymManager.AddSimulator(new BicycleSimulator(21700, 25, 3));
        gymManager.AddSimulator(new Simulator() {
            @Override
            public List<MuscleType> getMuscleTypes() {
                return new ArrayList<MuscleType>();
            }
            @Override
            public String work() {
                return "Anonymous simulator is working";
            }
            @Override
            public String toString() {
                return work();
            }
        });

        gymManager.AddExercise(new Exercise("Присідання", MuscleType.Hip));
        gymManager.AddExercise(new Exercise("Жим лежачи", MuscleType.Chest));
        gymManager.AddExercise(new Exercise("Згинання рук з гантелями", MuscleType.Biceps));
        gymManager.AddExercise(new Exercise("Розгинання рук з гантелями у горизонтальному положенні", MuscleType.Triceps));
        gymManager.AddExercise(new Exercise("Згинання тулуба", MuscleType.Abdominis));

        System.out.println("Початковий стан тренажерів:");
        gymManager.showSimulators();
        separateLine();

        System.out.println("Сортування тренажерів за ціною (від меншого до більшого):");
        GymManager.SimulatorsSortManager.sortByPriceAsc(gymManager.getSimulatorList());
        gymManager.showSimulators();
        separateLine();

        System.out.println("Сортування тренажерів за ціною (від більшого до меншого):");
        GymManager.SimulatorsSortManager.sortByPriceDesc(gymManager.getSimulatorList());
        gymManager.showSimulators();
        separateLine();

        System.out.println("Сортування тренажерів за використанням (від меншого до більшого):");
        GymManager.SimulatorsSortManager.sortByUsgPerDayAsc(gymManager.getSimulatorList());
        gymManager.showSimulators();
        separateLine();

        System.out.println("Сортування тренажерів за використанням (від більшого до меншого):");
        GymManager.SimulatorsSortManager.sortByUsgPerDayDesc(gymManager.getSimulatorList());
        gymManager.showSimulators();
        separateLine();

        System.out.println("Виведення програми");
        gymManager.ProgramSimulatorsSearch();
    }

    private static void separateLine()
    {
        for (int i = 0; i < 40; i++) System.out.print('_');
        System.out.println(' ');
        System.out.println(' ');
    }

}
