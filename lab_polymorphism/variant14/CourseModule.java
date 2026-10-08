package lab_polymorphism.variant14;

// Абстрактный базовый класс модуля онлайн-курса
public abstract class CourseModule implements Trackable {
    private final String title;   // название модуля
    private int maxScore;         // максимальный балл за модуль

    protected CourseModule(String title, int maxScore) {
        this.title = title;
        setMaxScore(maxScore);
    }

    public String getTitle() {
        return title;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        if (maxScore <= 0) {
            throw new IllegalArgumentException("Максимальный балл должен быть > 0");
        }
        this.maxScore = maxScore;
    }

    // Абстрактный метод: оставшееся время прохождения, мин
    public abstract int estimateCompletionTime();

    // Абстрактный метод: тип модуля для вывода
    public abstract String getModuleType();

    // Общий метод: вызывает переопределённые методы потомка (позднее связывание)
    public String getInfo() {
        return String.format("[%s] %s | осталось ~%d мин | %s",
                getModuleType(), title, estimateCompletionTime(), checkProgress());
    }

    // Перегрузка evaluate(): баллы из maxScore
    public String evaluate(int points) {
        return evaluate(points, maxScore);
    }

    // Перегрузка evaluate(): баллы из произвольного максимума
    public String evaluate(int points, int outOf) {
        if (points < 0 || points > outOf) {
            throw new IllegalArgumentException("Баллы вне диапазона 0.." + outOf);
        }
        double percent = 100.0 * points / outOf;
        return String.format("%d/%d = %.1f%% -> %s", points, outOf, percent, toGrade(percent));
    }

    // Перегрузка evaluate(): несколько попыток, засчитывается лучшая
    public String evaluate(int[] attempts) {
        int best = 0;
        for (int a : attempts) best = Math.max(best, a);
        return "лучшая из " + attempts.length + " попыток: " + evaluate(best);
    }

    // Перевод процентов в буквенную оценку
    protected static String toGrade(double percent) {
        if (percent >= 95) return "A";
        if (percent >= 90) return "A-";
        if (percent >= 85) return "B+";
        if (percent >= 80) return "B";
        if (percent >= 75) return "B-";
        if (percent >= 70) return "C+";
        if (percent >= 65) return "C";
        if (percent >= 60) return "C-";
        if (percent >= 55) return "D+";
        if (percent >= 50) return "D";
        return "F";
    }
}
