public class Lab1_Part1_Task14 {

    public static void main(String[] args) {
        double[] radii = {1.0, 2.5, 5.0, 10.0};

        System.out.println("Zadacha 14 (Tochka v kruge, popadanie v kvadrat):");
        System.out.println("     R      S kruga   S kvadrata        p");

        for (int i = 0; i < radii.length; i++) {
            double R = radii[i];
            double a = R * Math.sqrt(2);          // storona vpisannogo kvadrata
            double sSquare = a * a;               // ploshchad kvadrata = 2R^2
            double sCircle = Math.PI * R * R;     // ploshchad kruga = pi*R^2
            double p = sSquare / sCircle;         // geometricheskaya veroyatnost

            System.out.printf("%6.1f %12.4f %12.4f %8.4f%n", R, sCircle, sSquare, p);
        }

        System.out.printf("Teoreticheski: p = 2/pi = %.4f%n", 2 / Math.PI);
    }
}
