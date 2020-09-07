import java.util.Scanner;                                //Задание №27. Дана целочисленная матрица размера M*N, заполненная случайными значениями в диапазоне от -99 до 99.
import java.util.Random;                                 //Удалить ее последний столбец, содержащий только отрицательные элементы. Если требуемых столбцов нет, то вывести матрицу без изменений.
//матрица_удалить_последний_отрицательный_столбец
public class Algorithm27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        getMatrix(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
    }

    private static int[][] initialize(int M, int N) {
        return new int[M][N];
    }

    private static void fillingRandom(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        Random r = new Random();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = r.nextInt(199) - 99;
            }
        }
    }

    //метод нахождения отрицательного столбца
    private static int findColumn(int[][] matrix) {
        int N = matrix[0].length;
        boolean isNegative;
        for (int j = N - 1; j >= 0; j--) {
            isNegative = true;
            for (int[] ints : matrix)
                if (ints[j] >= 0) {
                    isNegative = false;
                    break;
                }
            if (isNegative) return j;
        }
        return -1;
    }

    private static int[][] createNewMatrix(int M, int N) {
        return new int[M][N];
    }

    //метод копирования из старой матрицы в новую
    private static int[][] copyMatrix(int[][] matrix, int negativeColumn) {
        int M = matrix.length;
        int N = matrix[0].length;
        if (negativeColumn == -1) return matrix;
        int[][] newMatrix = createNewMatrix(M, N - 1);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < negativeColumn; j++)
                newMatrix[i][j] = matrix[i][j];
            for (int j = negativeColumn + 1; j < N; j++)
                newMatrix[i][j - 1] = matrix[i][j];
        }
        return newMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        int N = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < N; j++) {
                System.out.print(String.format("%d\t", ints[j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void getMatrix(int M, int N) //Метод получаения нужной матрицы
    {
        int[][] matrix = createNewMatrix(M, N);
        fillingRandom(matrix);
        printMatrix(matrix);
        matrix = copyMatrix(matrix, findColumn(matrix));
        printMatrix(matrix);
    }
}