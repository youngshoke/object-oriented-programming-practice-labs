package lab_polymorphism.variant14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VideoLecture lecture = new VideoLecture("Vvedenie v OOP", 10, 90, 1.5);
        InteractiveQuiz quiz = new InteractiveQuiz("Test: nasledovanie", 20, 15, 2, 3);
        ProgrammingTask task = new ProgrammingTask("Ierarkhiya figur", 30, 12, 2);
        lecture.watch(45);
        quiz.answer(9);
        task.runTests(8);

        List<CourseModule> modules = new ArrayList<>();
        modules.add(lecture);
        modules.add(quiz);
        modules.add(task);

        System.out.println("=== DINAMIChESKIY POLIMORFIZM ===");
        int totalTime = 0;
        for (CourseModule m : modules) {
            // metod vybiraetsya po fakticheskomu tipu obekta
            System.out.println(m.getClass().getSimpleName() + ": " + m.getTitle());
            System.out.println("  Progress: " + m.checkProgress());
            System.out.println("  Ostalos: " + m.estimateCompletionTime() + " min");
            totalTime += m.estimateCompletionTime();
        }
        System.out.println("Vsego do zaversheniya kursa: " + totalTime + " min");

        System.out.println();
        System.out.println("=== VYZOV ChEREZ INTERFEYS Trackable ===");
        Trackable[] items = {lecture, quiz, task};
        for (Trackable t : items) {
            System.out.printf("%-16s %5.1f%%%n", t.getClass().getSimpleName(), t.getProgressPercent());
        }

        System.out.println();
        System.out.println("=== POSLE PRODOLZhENIYa OBUChENIYa ===");
        lecture.watch(30);
        quiz.answer(6);
        task.runTests(11);
        for (CourseModule m : modules) {
            System.out.println(m.getInfo());
        }
    }
}
