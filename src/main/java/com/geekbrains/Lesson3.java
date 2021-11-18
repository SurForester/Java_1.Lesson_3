package com.geekbrains;

import java.util.Arrays;

public class Lesson3 {

    public static void main(String[] args) {
        // Задание №1
        int[] arrOne = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arrOne.length; i++) {
            if (arrOne[i] == 1) {
                arrOne[i] = 0;
            } else {
                arrOne[i] = 1;
            }
        }
        System.out.println("Задание 1.");
        System.out.println(Arrays.toString(arrOne));

        // Задание №2
        int[] arrTwo = new int[100];
        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i] = i + 1;
        }
        System.out.println("\nЗадание 2.");
        System.out.println(Arrays.toString(arrTwo));

        // Задание 3.
        int[] arrThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrThree.length; i++) {
            if (arrThree[i] < 6) {
                arrThree[i] *= 2;
            }
        }
        System.out.println("\nЗадание 3.");
        System.out.println(Arrays.toString(arrThree));

        // Задание 4.
        int[][] arrDFour = new int[5][5];
        for (int i = 0; i < arrDFour.length; i++) {
            for (int j = 0; j < arrDFour[0].length; j++) {
                if (i == j || j == (arrDFour.length - i - 1)) {
                    arrDFour[i][j] = 1;
                }
            }
        }
        System.out.println("\nЗадание 4.");
        for (int[] ints : arrDFour) {
            System.out.println(Arrays.toString(ints));
        }

        // Задание 5.
        int[] arrProc = createArr(10, 111);
        System.out.println("\nЗадание 5.");
        System.out.println(Arrays.toString(arrProc));

        // Задание 6.
        int[] arrMinMax = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min, max;
        min = max = arrMinMax[0];
        for (int i = 1; i < arrMinMax.length; i++) {
            if (min > arrMinMax[i]) {
                min = arrMinMax[i];
            }
            if (max < arrMinMax[i]) {
                max = arrMinMax[i];
            }
        }
        System.out.println("\nЗадание 6.");
        System.out.println(Arrays.toString(arrMinMax));
        System.out.printf("min = %d,  max = %d\n", min, max);

        // Задание 7.
        System.out.println("\nЗадание 7.");
        int[] arrSum = {3, 5, 22, 15, 4, 7, 11};
        System.out.println(sumLineFind(arrSum));
        int[] arrSum2 = {10, 5, 22, 15, 4, 7, 11};
        System.out.println(sumLineFind(arrSum2));
        int[] arrSum3 = {1, 1, 1, 2, 1};
        System.out.println(sumLineFind(arrSum3));

        // задание 8.
        System.out.println("\nЗадание 7.");
        int[] arrSh = {3, 5, 22, 15, 4, 7, 11};
        arrShift(arrSh, 2);
        arrShift(arrSh, -3);
        arrShift(arrSh, 0);
    }

    // create 1-D array
    private static int[] createArr(int len, int initVal) {
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = initVal;
        }
        return result;
    }

    // поиск равносуммной границы в одномерном массиве
    private static boolean sumLineFind(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int sumLeft = 0, sumRight = 0;
            for (int j = i - 1; j >= 0; j--) {
                sumLeft += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                // print array
                System.out.print("[");
                for (int j = 0; j < arr.length; j++) {
                    if (i == j) {
                        System.out.print(" ||| ");
                    }
                    System.out.print(arr[j]);
                    if (j < arr.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.print("] -> ");
                return true;
            }
        }
        System.out.print(Arrays.toString(arr) + " -> ");
        return false;
    }

    // array shift
    private static void arrShift(int[] arr, int n) {
        System.out.println("Изначальный массив - " + Arrays.toString(arr));
        int bufInt;
        if (n > 0) {
            // shift to right
            for (int j = 0; j < n; j++) {
                bufInt = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = bufInt;
            }
        } else if (n < 0) {
            // shift to left
            for (int j = 0; j > n; j--) {
                bufInt = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = bufInt;
            }
        }
        System.out.println("После сдвига на " + n + " - " + Arrays.toString(arr));
        System.out.println("Сдвиг на положительное число - вправо, отрицательное - влево.");
    }
}
