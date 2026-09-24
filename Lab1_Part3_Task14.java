import java.util.Scanner;

public class Lab1_Part3_Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;

        System.out.println("--- Графические форматы файлов ---");

        while (continueInput) {
            System.out.print("\nВведите число от 1 до 4 (или 0 для выхода): ");

            // Защита от ввода нечисловых значений (букв, символов)
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Пожалуйста, введите целое число.");
                scanner.next(); // Очистка некорректного ввода из буфера
                continue;
            }

            int number = scanner.nextInt();

            // Оператор выбора switch
            switch (number) {
                case 0:
                    System.out.println("Завершение работы программы.");
                    continueInput = false;
                    break;
                case 1:
                    System.out.println("Тип файла: BMP (Bitmap)");
                    break;
                case 2:
                    System.out.println("Тип файла: GIF (Graphics Interchange Format)");
                    break;
                case 3:
                    System.out.println("Тип файла: JPG / JPEG (Joint Photographic Experts Group)");
                    break;
                case 4:
                    System.out.println("Тип файла: PNG (Portable Network Graphics)");
                    break;
                default:
                    System.out.println("Неверное число! Повторите ввод (введите число от 1 до 4).");
                    break;
            }
        }

        scanner.close();
    }
}