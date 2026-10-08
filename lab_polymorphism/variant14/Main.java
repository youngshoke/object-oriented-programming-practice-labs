package lab_polymorphism.variant14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VideoLecture lecture = new VideoLecture("Введение в ООП", 10, 90, 1.5);
        InteractiveQuiz quiz = new InteractiveQuiz("Тест: наследование", 20, 15, 2, 3);
        ProgrammingTask task = new ProgrammingTask("Иерархия фигур", 30, 12, 2);
        lecture.watch(45);
        quiz.answer(9);
        task.runTests(8);

        List<CourseModule> modules = new ArrayList<>();
        modules.add(lecture);
        modules.add(quiz);
        modules.add(task);

        System.out.println("=== ДИНАМИЧЕСКИЙ ПОЛИМОРФИЗМ ===");
        int totalTime = 0;
        for (CourseModule m : modules) {
            // метод выбирается по фактическому типу объекта
            System.out.println(m.getClass().getSimpleName() + ": " + m.getTitle());
            System.out.println("  Прогресс: " + m.checkProgress());
            System.out.println("  Осталось: " + m.estimateCompletionTime() + " мин");
            totalTime += m.estimateCompletionTime();
        }
        System.out.println("Всего до завершения курса: " + totalTime + " мин");

        System.out.println();
        System.out.println("=== ВЫЗОВ ЧЕРЕЗ ИНТЕРФЕЙС Trackable ===");
        Trackable[] items = {lecture, quiz, task};
        for (Trackable t : items) {
            System.out.printf("%-16s %5.1f%%%n", t.getClass().getSimpleName(), t.getProgressPercent());
        }

        System.out.println();
        System.out.println("=== ПОСЛЕ ПРОДОЛЖЕНИЯ ОБУЧЕНИЯ ===");
        lecture.watch(30);
        quiz.answer(6);
        task.runTests(11);
        for (CourseModule m : modules) {
            System.out.println(m.getInfo());
        }
    }
}
