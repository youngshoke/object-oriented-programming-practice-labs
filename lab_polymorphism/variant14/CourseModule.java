package lab_polymorphism.variant14;

// Abstraktnyy bazovyy klass modulya onlayn-kursa
public abstract class CourseModule implements Trackable {
    private final String title;   // nazvanie modulya
    private int maxScore;         // maksimalnyy ball za modul

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
            throw new IllegalArgumentException("Maksimalnyy ball dolzhen byt > 0");
        }
        this.maxScore = maxScore;
    }

    // Abstraktnyy metod: ostavsheesya vremya prokhozhdeniya, min
    public abstract int estimateCompletionTime();

    // Abstraktnyy metod: tip modulya dlya vyvoda
    public abstract String getModuleType();

    // Obshchiy metod: vyzyvaet pereopredelyonnye metody potomka (pozdnee svyazyvanie)
    public String getInfo() {
        return String.format("[%s] %s | ostalos ~%d min | %s",
                getModuleType(), title, estimateCompletionTime(), checkProgress());
    }

    // Peregruzka evaluate(): bally iz maxScore
    public String evaluate(int points) {
        return evaluate(points, maxScore);
    }

    // Peregruzka evaluate(): bally iz proizvolnogo maksimuma
    public String evaluate(int points, int outOf) {
        if (points < 0 || points > outOf) {
            throw new IllegalArgumentException("Bally vne diapazona 0.." + outOf);
        }
        double percent = 100.0 * points / outOf;
        return String.format("%d/%d = %.1f%% -> %s", points, outOf, percent, toGrade(percent));
    }

    // Peregruzka evaluate(): neskolko popytok, zaschityvaetsya luchshaya
    public String evaluate(int[] attempts) {
        int best = 0;
        for (int a : attempts) best = Math.max(best, a);
        return "luchshaya iz " + attempts.length + " popytok: " + evaluate(best);
    }

    // Perevod protsentov v bukvennuyu otsenku
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
