package quicksort;

import java.util.*;

public class Main {

    public static void moveThePivot(int[] array, int pivotIndex) {
        // write your code here
        int pivot = array[pivotIndex];  // choose the rightmost element as the pivot
        int partitionIndex = 0; // the first element greater than the pivot
        /* move large values into the right side of the array */
        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) { // may be used '<' as well
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, array.length - 1); // put the pivot on a suitable position
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /* Do not change code below */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] array = Arrays.stream(scanner.nextLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
//        int pivotIndex = scanner.nextInt();

        int[] array = {17, 25, 11, 16, 10, 13, 22, 14};
        int pivotIndex = 2;
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
        System.out.println();
        moveThePivot(array, pivotIndex);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}
