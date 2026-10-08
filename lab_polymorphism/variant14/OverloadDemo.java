package lab_polymorphism.variant14;

import java.util.Scanner;

public class OverloadDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        InteractiveQuiz quiz = new InteractiveQuiz("Test: polimorfizm", 20, 10, 2, 3);
        ProgrammingTask task = new ProgrammingTask("Kalkulyator figur", 30, 10, 3);

        System.out.println("=== STATIChESKIY POLIMORFIZM (PEREGRUZKA evaluate) ===");
        System.out.print("Bally za test (iz 20): ");
        int points = in.nextInt();
        System.out.println("evaluate(int)          : " + quiz.evaluate(points));
        System.out.println("evaluate(int, int)     : " + quiz.evaluate(points, 25));

        System.out.print("Bally tryokh popytok: ");
        int[] attempts = {in.nextInt(), in.nextInt(), in.nextInt()};
        System.out.println("evaluate(int[])        : " + quiz.evaluate(attempts));

        System.out.print("Proydeno testov zadachi (iz 10): ");
        int passed = in.nextInt();
        System.out.println("evaluate(int,int,true) : " + task.evaluate(passed, 10, true));
        System.out.println("evaluate(int,int,false): " + task.evaluate(passed, 10, false));

        // Tip ssylki CourseModule: metod evaluate(int,int,boolean) ne viden,
        // peregruzka vybiraetsya kompilyatorom po tipu ssylki i argumentam
        CourseModule module = task;
        System.out.println("CourseModule.evaluate(int): " + module.evaluate(27));

        try {
            quiz.evaluate(30);
        } catch (IllegalArgumentException e) {
            System.out.println("Oshibka: " + e.getMessage());
        }
    }
}
