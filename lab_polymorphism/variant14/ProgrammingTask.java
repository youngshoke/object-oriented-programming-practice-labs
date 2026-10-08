package lab_polymorphism.variant14;

// Задача по программированию: прогресс по пройденным автотестам
public class ProgrammingTask extends CourseModule {
    private final int totalTests;    // всего автотестов
    private final int difficulty;    // сложность 1..3
    private int passedTests;         // пройдено автотестов

    public ProgrammingTask(String title, int maxScore, int totalTests, int difficulty) {
        super(title, maxScore);
        this.totalTests = totalTests;
        this.difficulty = difficulty;
    }

    public void runTests(int passed) {
        passedTests = Math.min(totalTests, passed);
    }

    @Override
    public int estimateCompletionTime() {
        if (passedTests == totalTests) return 0;
        // 60 мин на уровень сложности за оставшиеся тесты + 15 мин на код-ревью
        return 60 * difficulty * (totalTests - passedTests) / totalTests + 15;
    }

    @Override
    public double getProgressPercent() {
        return 100.0 * passedTests / totalTests;
    }

    @Override
    public String checkProgress() {
        return String.format("пройдено тестов %d/%d, сложность %d",
                passedTests, totalTests, difficulty);
    }

    @Override
    public String getModuleType() {
        return "Задача";
    }

    // Ещё одна перегрузка evaluate(): тесты + штраф за стиль кода
    public String evaluate(int passed, int total, boolean codeStyleOk) {
        int points = getMaxScore() * passed / total;
        if (!codeStyleOk) points -= getMaxScore() / 10;   // штраф 10%
        return "тесты " + passed + "/" + total + (codeStyleOk ? "" : ", штраф за стиль")
                + ": " + evaluate(Math.max(points, 0));
    }
}
