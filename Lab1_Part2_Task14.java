import java.util.Random;

public class Lab1_Part2_Task14 {

    public static void main(String[] args) {
        double R = 1.0;
        double half = R / Math.sqrt(2);          // polovina storony kvadrata
        double pTheor = 2 / Math.PI;
        int[] trials = {1000, 10000, 100000, 1000000};
        Random rnd = new Random(14);

        System.out.println("Zadacha 14 (Proverka metodom Monte-Karlo, R = 1):");
        System.out.println("        N          M    w = M/N    |w - p|");

        for (int k = 0; k < trials.length; k++) {
            int N = trials[k];
            int inCircle = 0, inSquare = 0;

            while (inCircle < N) {
                double x = (2 * rnd.nextDouble() - 1) * R;
                double y = (2 * rnd.nextDouble() - 1) * R;

                if (x * x + y * y <= R * R) {        // tochka popala v krug
                    inCircle++;
                    if (Math.abs(x) <= half && Math.abs(y) <= half) {
                        inSquare++;                   // i v kvadrat
                    }
                }
            }

            double w = (double) inSquare / N;       // otnositelnaya chastota
            System.out.printf("%9d %10d %10.4f %10.4f%n",
                    N, inSquare, w, Math.abs(w - pTheor));
        }

        System.out.printf("Teoreticheskaya veroyatnost p = 2/pi = %.4f%n", pTheor);
    }
}
