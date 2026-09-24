public class Lab2_part1_Task14 {
   
    public static void main(String[] args) {
        double a = 2.0, b = 4.0, h = 0.2;
        int n = (int) Math.round((b - a) / h);

        double max = Double.NEGATIVE_INFINITY, min = Double.POSITIVE_INFINITY;
        double xMax = a, xMin = a, sumNeg = 0;

        System.out.println("Zadacha 1 (Y = cos(X) + 0.3X, X ot 2 do 4, h = 0.2):");
        System.out.println("   X         Y");

        for (int i = 0; i <= n; i++) {
            double x = a + i * h;
            double y = Math.cos(x) + 0.3 * x;

            System.out.printf("%5.1f   %8.4f%n", x, y);

            if (y > max) {
                max = y;
                xMax = x;
            }

            if (y < min) {
                min = y;
                xMin = x;
            }

            if (y < 0) {
                sumNeg += y;
            }
        }

        System.out.printf("Max = %.4f pri X = %.1f%n", max, xMax);
        System.out.printf("Min = %.4f pri X = %.1f%n", min, xMin);
        System.out.printf("Summa otricatelnykh Y = %.4f%n", sumNeg);
    }
}