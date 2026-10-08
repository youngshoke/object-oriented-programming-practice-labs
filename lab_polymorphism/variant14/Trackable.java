package lab_polymorphism.variant14;

// Интерфейс - контракт отслеживания прогресса
public interface Trackable {
    double getProgressPercent();   // доля выполнения, %
    String checkProgress();        // текстовый отчёт о прогрессе
}
