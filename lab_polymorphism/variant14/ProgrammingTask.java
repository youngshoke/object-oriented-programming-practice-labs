package lab_polymorphism.variant14;

// Zadacha po programmirovaniyu: progress po proydennym avtotestam
public class ProgrammingTask extends CourseModule {
    private final int totalTests;    // vsego avtotestov
    private final int difficulty;    // slozhnost 1..3
    private int passedTests;         // proydeno avtotestov

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
        // 60 min na uroven slozhnosti za ostavshiesya testy + 15 min na kod-revyu
        return 60 * difficulty * (totalTests - passedTests) / totalTests + 15;
    }

    @Override
    public double getProgressPercent() {
        return 100.0 * passedTests / totalTests;
    }

    @Override
    public String checkProgress() {
        return String.format("proydeno testov %d/%d, slozhnost %d",
                passedTests, totalTests, difficulty);
    }

    @Override
    public String getModuleType() {
        return "Zadacha";
    }

    // Eshchyo odna peregruzka evaluate(): testy + shtraf za stil koda
    public String evaluate(int passed, int total, boolean codeStyleOk) {
        int points = getMaxScore() * passed / total;
        if (!codeStyleOk) points -= getMaxScore() / 10;   // shtraf 10%
        return "testy " + passed + "/" + total + (codeStyleOk ? "" : ", shtraf za stil")
                + ": " + evaluate(Math.max(points, 0));
    }
}
