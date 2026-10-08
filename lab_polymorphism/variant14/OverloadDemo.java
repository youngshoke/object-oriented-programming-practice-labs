package lab_polymorphism.variant14;

import java.util.Scanner;

public class OverloadDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        InteractiveQuiz quiz = new InteractiveQuiz("Тест: полиморфизм", 20, 10, 2, 3);
        ProgrammingTask task = new ProgrammingTask("Калькулятор фигур", 30, 10, 3);

        System.out.println("=== СТАТИЧЕСКИЙ ПОЛИМОРФИЗМ (ПЕРЕГРУЗКА evaluate) ===");
        System.out.print("Баллы за тест (из 20): ");
        int points = in.nextInt();
        System.out.println("evaluate(int)          : " + quiz.evaluate(points));
        System.out.println("evaluate(int, int)     : " + quiz.evaluate(points, 25));

        System.out.print("Баллы трёх попыток: ");
        int[] attempts = {in.nextInt(), in.nextInt(), in.nextInt()};
        System.out.println("evaluate(int[])        : " + quiz.evaluate(attempts));

        System.out.print("Пройдено тестов задачи (из 10): ");
        int passed = in.nextInt();
        System.out.println("evaluate(int,int,true) : " + task.evaluate(passed, 10, true));
        System.out.println("evaluate(int,int,false): " + task.evaluate(passed, 10, false));

        // Тип ссылки CourseModule: метод evaluate(int,int,boolean) не виден,
        // перегрузка выбирается компилятором по типу ссылки и аргументам
        CourseModule module = task;
        System.out.println("CourseModule.evaluate(int): " + module.evaluate(27));

        try {
            quiz.evaluate(30);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
