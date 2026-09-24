public class Lab2_part1_Task14 {
   public static void main(String[] args) {
        double a = 2.0;
        double b = 4.0;
        double h = 0.2;

        double minY = Double.MAX_VALUE;
        double xMin = a;
        double sumOtric = 0.0;

        System.out.println("--- Tabulirovanie funktsii: Y = cos(X) + 0.3X ---");
        System.out.printf("%-10s | %-10s\n", "X", "Y");
        System.out.println("-----------------------");

        for (double x = a; x <= b + 1e-9; x += h) {
            double y = Math.cos(x) + 0.3 * x;
            System.out.printf("%-10.2f | %-10.4f\n", x, y);

            if (y < minY) {
                minY = y;
                xMin = x;
            }

            if (y < 0) {
                sumOtric += y;
            }
        }

        System.out.println("-----------------------");
        System.out.printf("Minimalnoe znachenie Y (Min): %.4f (pri X = %.2f)\n", minY, xMin);
        System.out.printf("Summa otricatelnyh Y: %.4f\n", sumOtric);
    }
}
