import java.util.Scanner;

public class Lab1_Part2_Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x: ");
        double x = scanner.nextDouble();
        double y;

        if (x > 0) {
            y = x * x + 2 * x;
        } else if (x == 0) {
            y = Math.sqrt(2);
        } else {
            y = 2 * x - x * x;
        }

        System.out.printf("Раздел 2, Задание 14: y = %.2f%n", y);
        scanner.close();
    }
}