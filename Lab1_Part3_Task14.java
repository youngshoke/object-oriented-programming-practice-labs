import java.util.Scanner;

public class Lab1_Part3_Task14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Zadacha 14 (Tip graficheskogo faila po nomeru):");
        System.out.println("1 - BMP, 2 - GIF, 3 - JPG, 4 - PNG, 0 - vykhod");

        while (running) {
            System.out.print("Vvedite chislo ot 1 do 4: ");

            if (!sc.hasNextInt()) {                  // zashchita ot vvoda teksta
                System.out.println("Oshibka! Nuzhno vvesti tseloe chislo.");
                sc.next();                           // ochistka nevernogo vvoda
                continue;
            }

            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Tip faila: BMP (Bitmap)");
                    break;
                case 2:
                    System.out.println("Tip faila: GIF (Graphics Interchange Format)");
                    break;
                case 3:
                    System.out.println("Tip faila: JPG (JPEG)");
                    break;
                case 4:
                    System.out.println("Tip faila: PNG (Portable Network Graphics)");
                    break;
                case 0:
                    System.out.println("Zavershenie raboty programmy.");
                    running = false;
                    break;
                default:
                    System.out.println("Nevernoe chislo! Dopustimo ot 1 do 4.");
            }
        }

        sc.close();
    }
}
