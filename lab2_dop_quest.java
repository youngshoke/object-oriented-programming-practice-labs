public class lab2_dop_quest {


    public static void main(String[] args) {

        double[][] A = {
            { 2.0, -1.0,  3.0,  0.5, -4.0},
            {-2.5,  4.0,  1.5, -3.0,  2.0},
            { 1.0,  1.0, -6.0,  5.0,  0.0},
            {-1.0, -3.0,  0.0, -2.0, -5.0},
            { 3.0,  2.5, -1.0,  2.0,  1.0},
            { 0.5, -2.0,  6.0, -1.5,  4.0}
        };

        int rows = A.length;
        int cols = A[0].length;

        double[] P = new double[rows];

        System.out.println("Srednee arifmeticheskoe polozhitelnykh elementov kazhdoi stroki:");
        System.out.println("Matritsa A:");

        // Вывод матрицы
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                System.out.printf("%7.1f", A[i][j]);
            }

            System.out.println();
        }

        // Поиск среднего арифметического положительных элементов
        for (int i = 0; i < rows; i++) {

            double sum = 0;
            int count = 0;

            for (int j = 0; j < cols; j++) {

                if (A[i][j] > 0) {
                    sum += A[i][j];
                    count++;
                }
            }

            if (count > 0) {
                P[i] = sum / count;
                System.out.printf("P(%d) = %.2f%n", i + 1, P[i]);
            } else {
                P[i] = 0;
                System.out.printf("P(%d) = 0 (polozhitelnykh net)%n", i + 1);
            }
        }
    }
}

