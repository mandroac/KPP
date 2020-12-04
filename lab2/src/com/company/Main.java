package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Map<Integer, ArrayList<Car>> carsMap = new HashMap<>();

        var cars = new ArrayList<Car>();

        File file1 = new File("cars1");
        File file2 = new File("cars2");
        try {
            cars.addAll(getCarsFromFile(file1));
            cars.addAll(getCarsFromFile(file2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        carsMap = fillMapFromCarList(cars);

        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean runProgram = true;
        while (runProgram) {
            System.out.println("""
                            \t
                            Меню
                    1. Вивести n перших елементів з карти
                    2. Видалити автомобілі з карти за маркою
                    3. Відсортувати список автомобілів у зворотньому порядку за маркою
                    4. Знайти кількість автомобілів у певному діапазоні вартості
                    0. Вийти із програми
                    """);

            input = sc.nextLine();
            input.trim();
            try {
                int mode = Integer.parseInt(input);
                switch (mode) {
                    case 0 -> runProgram = false;
                    case 1 -> startTask1(carsMap,sc);
                    case 2 -> startTask2(carsMap,sc);
                    case 3 -> startTask3(cars);
                    case 4 -> startTask4(cars, sc);
                    default -> System.out.println("Bad Input");
                }
            } catch (Exception e) {
                System.out.println("Bad Input");
            }
        }
    }

    private static void startTask1(Map<Integer, ArrayList<Car>> carsMap ,Scanner sc) {

        System.out.println("Введіть n:\n");
        String input = "";
        boolean validN = false;
        int n = -1;
        while (!validN) {
            input = sc.nextLine();
            try {
                n = Integer.parseInt(input);
                validN = true;
                task1(carsMap,n);
            } catch (Exception e) {
                System.out.println("Bad input");
            }
        }

    }

    private static void task1(Map<Integer, ArrayList<Car>> carsMap, int n) {

        for (Map.Entry<Integer, ArrayList<Car>> listEntry : carsMap.entrySet())
            System.out.println(listEntry.getKey() + ": " + listEntry.getValue().subList(0, Math.min(n, listEntry.getValue().size())));
    }

    private static void startTask2(Map<Integer, ArrayList<Car>> carsMap ,Scanner sc) {
        System.out.println("Введіть марки автомобілів які потрібно видалити через пробіли:\n");
        String input = "";
        input = sc.nextLine();
        String[] carsToRemove = input.split(" ");
        for (var carModel: carsToRemove
             ) {
            for (Map.Entry<Integer, ArrayList<Car>> listEntry : carsMap.entrySet())
                listEntry.getValue().removeIf(car -> (car.getBrand().matches(carModel)));
            }
        System.out.println(carsMap);
    }

    private static void startTask3(ArrayList<Car> cars) {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getBrand().compareTo(o1.getBrand());
            }
        });
        System.out.println(cars);
    }

    private static void startTask4(ArrayList<Car> cars, Scanner sc) {
        boolean validA = false;
        boolean validB = false;
        int a = -1;
        int b = -1;
        System.out.println("Вартість від: ");
        String input = "";
        while (!validA) {
            input = sc.nextLine();
            try {
                a = Integer.parseInt(input);
                validA = true;
            } catch (Exception e) {
                System.out.println("Bad input");
            }
        }
        System.out.println("до: ");
        input = "";
        while (!validB) {
            input = sc.nextLine();
            try {
                b = Integer.parseInt(input);
                validB = true;
            } catch (Exception e) {
                System.out.println("Bad input");
            }
        }

        int finalB = b;
        int finalA = a;
        System.out.println(cars.stream().sorted(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        }).dropWhile(car -> car.getPrice() < finalA).takeWhile(car -> car.getPrice() < finalB).collect(Collectors.toList()));
    }


    private static ArrayList<Car> getCarsFromFile(File file) throws IOException {
        ArrayList<Car> carsList = new ArrayList<>();
        BufferedReader  bufferedReader = new BufferedReader( new FileReader(file));
        String line;

        while ((line = bufferedReader.readLine()) != null){
            String[] parts = line.split(" ");
            carsList.add(new Car(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        return carsList;
    }

    private static Map<Integer, ArrayList<Car>> fillMapFromCarList(ArrayList<Car> carsList) {
        Map<Integer, ArrayList<Car>> carsMap = new HashMap<>();

        for (var car: carsList) {
            ArrayList<Car> buffer = carsMap.get(car.getMaxSpeed());
            if (buffer == null) buffer = new ArrayList<Car>();
            buffer.add(car);
            carsMap.put(car.getMaxSpeed(), buffer);
        }

        return carsMap;
    }

}
