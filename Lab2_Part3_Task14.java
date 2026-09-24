public class Lab2_Part3_Task14 {

    public static void main(String[] args) {

        int[] X = {-3, 5, -1, 8, -7, 2, 12, -4, 6, -9};

        System.out.println("Zadacha 3 (Obnulenie otricatelnykh do naibolshego):");

        System.out.print("Iskhodnyy X: ");

        for (int v : X)
            System.out.print(v + " ");

        System.out.println();

        int iMax = 0;

        for (int i = 1; i < X.length; i++) {

            if (X[i] > X[iMax])
                iMax = i;
        }

        System.out.println("Naibolshiy element X(" + (iMax + 1) + ") = " + X[iMax]);

        for (int i = 0; i < iMax; i++) {

            if (X[i] < 0)
                X[i] = 0;
        }

        System.out.print("Itogovyy X: ");

        for (int v : X)
            System.out.print(v + " ");

        System.out.println();
    }

}
