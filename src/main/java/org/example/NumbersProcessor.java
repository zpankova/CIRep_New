package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumbersProcessor {

    public static int min(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int minNum = Integer.MAX_VALUE;
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num < minNum) {
                    minNum = num;
                }
            }
            return minNum;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Integer.MIN_VALUE;
    }

    public static int max(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int maxNum = Integer.MIN_VALUE;
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num > maxNum) {
                    maxNum = num;
                }
            }
            return maxNum;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Integer.MAX_VALUE;
    }

    public static int sum(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }
            return sum;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int mult(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int mult = 1;
            while (scanner.hasNextInt()) {
                mult *= scanner.nextInt();
            }
            return mult;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        String filename = "Check.txt";
        System.out.println("Минимальное число: " + min(filename));
        System.out.println("Максимальное число: " + max(filename));
        System.out.println("Сумма чисел: " + sum(filename));
        System.out.println("Произведение чисел: " + mult(filename));
    }
}