package question_01_07;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[][] matrix = {
                {00, 01, 02, 03, 04},
                {10, 11, 12, 13, 14},
                {20, 21, 22, 33, 24},
                {30, 31, 32, 33, 34},
                {40, 41, 42, 43, 44},
        };

        int n = 5;

        printMatrix(matrix);

        int startIndex = 0;
        int endIndex = n - 1 ;

        for (int i = 0; i < n / 2; i++) {
            int cash;
            for (int j = startIndex; j < endIndex; j++) {
                cash = matrix[j][i];
                matrix[j][i] = matrix[endIndex][j];
                matrix[endIndex][j] = matrix[endIndex-j][endIndex];
                matrix[endIndex-j][endIndex] = matrix[startIndex][endIndex-j];
                matrix[startIndex][endIndex-j] = cash;
            }
            startIndex++;
            endIndex--;
        }
        System.out.println();
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach(array-> System.out.println(Arrays.toString(array)));
    }
}
