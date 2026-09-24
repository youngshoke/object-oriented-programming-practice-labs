public class Lab2_Part2_Task14 {


    public static void main(String[] args) {

        double[] A = {3.5, -2.0, 1.2, 0.0, -4.1, 2.0, 5.0, -1.5,
                      0.5, 7.0, -3.3, 1.5, -6.0, 2.5, -0.8};

        System.out.println("Zadacha 2 (Proizvedenie polozhitelnykh elementov A(15)):");

        System.out.print("A = ");

        for (double v : A)
            System.out.print(v + " ");

        System.out.println();

        double p = 1;
        int count = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] > 0) {
                p *= A[i];
                count++;
            }
        }

        if (count == 0) {

            System.out.println("Polozhitelnykh elementov net");

        } else {

            System.out.println("Kolichestvo polozhitelnykh: " + count);
            System.out.printf("Proizvedenie polozhitelnykh = %.4f%n", p);
        }
    }

}
