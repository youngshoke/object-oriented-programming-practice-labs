package lab_polymorphism.variant14;

// Interaktivnyy test: progress po otvechennym voprosam
public class InteractiveQuiz extends CourseModule {
    private final int questionCount;     // vsego voprosov
    private final int minutesPerQuestion;
    private int answered;                // otvecheno voprosov
    private int attemptsLeft;            // ostavshiesya popytki

    public InteractiveQuiz(String title, int maxScore, int questionCount,
                           int minutesPerQuestion, int attempts) {
        super(title, maxScore);
        this.questionCount = questionCount;
        this.minutesPerQuestion = minutesPerQuestion;
        this.attemptsLeft = attempts;
    }

    public void answer(int count) {
        answered = Math.min(questionCount, answered + count);
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    @Override
    public int estimateCompletionTime() {
        return (questionCount - answered) * minutesPerQuestion;
    }

    @Override
    public double getProgressPercent() {
        return 100.0 * answered / questionCount;
    }

    @Override
    public String checkProgress() {
        return String.format("otvecheno %d iz %d voprosov, popytok: %d",
                answered, questionCount, attemptsLeft);
    }

    @Override
    public String getModuleType() {
        return "Test";
    }
}
