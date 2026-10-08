package lab_polymorphism.variant14;

// Interfeys - kontrakt otslezhivaniya progressa
public interface Trackable {
    double getProgressPercent();   // dolya vypolneniya, %
    String checkProgress();        // tekstovyy otchyot o progresse
}
