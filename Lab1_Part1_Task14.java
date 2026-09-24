public class Lab1_Part1_Task14 {
    public static void main(String[] args) {
        double a = Math.PI;
        double x = 2.0;
        double y = 3.0;

        // Math.pow(Math.sin(2 * a), 3) — синус в кубе
        // Math.sqrt(y - x) — квадратный корень
        double Z = (x + 3 * y - 1) / (Math.pow(Math.sin(2 * a), 3) + 10) - Math.sqrt(y - x);

        System.out.printf("Раздел 1, Задание 14: Z = %.2f%n", Z); // Вывод: Z = 0.00
    }
}