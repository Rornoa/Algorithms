import java.util.Scanner;

//Задание №23. Парными числами называются два простых числа, разность которых равна двум, например:3 5;5 7.
//Напишите программу нахождения первых N таких пар. N задается в программе.

public class Algorithm23 {
    public static void main(String[] args) {
        int N = Integer.parseInt(new Scanner(System.in).next()),
                count = 1, lastSimple = 0;
        System.out.println(3 + " " + 5);
        int j, i = 5;
        while (count < N) {
            double k = Math.sqrt(i);
            for (j = 3; j <= k; j += 2)
                if (i % j == 0)
                    break;
            if (j > k) {
                if (i - lastSimple == 2) {
                    System.out.println(lastSimple + " " + i);
                    count++;
                }
                lastSimple = i;
            }
            i += 2;
        }
    }
}
