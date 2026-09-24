public class Lab2_Part5_Task14 {

    public static void main(String[] args) {

        double[][] A = {
            { 2.0, -1.0,  3.0,  0.5, -4.0},
            {-2.5,  4.0,  1.5, -3.0,  2.0},
            { 1.0,  1.0, -6.0,  5.0,  0.0},
            {-1.0, -3.0,  0.0, -2.0, -5.0},
            { 3.0,  2.5, -1.0,  2.0,  1.0},
            { 0.5, -2.0,  6.0, -1.5,  4.0}
        };

        int rows = A.length, cols = A[0].length;

        double[] P = new double[rows];

        System.out.println("Zadacha 5 (Proizvedenie polozhitelnykh v strokakh A(6,5)):");

        System.out.println("Matritsa A:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                System.out.printf("%7.1f", A[i][j]);
            }

            System.out.println();
        }

        for (int i = 0; i < rows; i++) {

            double p = 1;
            boolean found = false;

            for (int j = 0; j < cols; j++) {

                if (A[i][j] > 0) {
                    p *= A[i][j];
                    found = true;
                }
            }

            P[i] = found ? p : 0;

            System.out.printf("P(%d) = %.2f%s%n", i + 1, P[i],
                    found ? "" : " (polozhitelnykh net)");
        }
    }
}
