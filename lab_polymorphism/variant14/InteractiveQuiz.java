package lab_polymorphism.variant14;

// Интерактивный тест: прогресс по отвеченным вопросам
public class InteractiveQuiz extends CourseModule {
    private final int questionCount;     // всего вопросов
    private final int minutesPerQuestion;
    private int answered;                // отвечено вопросов
    private int attemptsLeft;            // оставшиеся попытки

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
        return String.format("отвечено %d из %d вопросов, попыток: %d",
                answered, questionCount, attemptsLeft);
    }

    @Override
    public String getModuleType() {
        return "Тест";
    }
}
