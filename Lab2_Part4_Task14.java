public class Lab2_Part4_Task14 {

    public static void main(String[] args) {

        int[][] B = {
            { 4, -2,  7,  1,  9},
            { 3,  8, -5,  6,  2},
            {-1,  0, 11,  4, -3},
            { 5, 12,  3, -7,  8},
            {10, -6,  2,  1, 15}
        };

        int n = B.length;

        int[] X = new int[n];

        System.out.println("Zadacha 4 (Pobochnaya diagonal matritsy B(5,5)):");

        System.out.println("Matritsa B:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", B[i][j]);
            }

            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            X[i] = B[i][n - 1 - i];
        }

        System.out.print("Vektor X: ");

        for (int v : X)
            System.out.print(v + " ");

        System.out.println();
    }
}
