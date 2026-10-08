package lab_polymorphism.variant14;

// Видеолекция: прогресс по просмотренным минутам
public class VideoLecture extends CourseModule {
    private final int videoMinutes;   // длительность видео
    private int watchedMinutes;       // просмотрено минут
    private double playbackSpeed;     // скорость воспроизведения

    public VideoLecture(String title, int maxScore, int videoMinutes, double playbackSpeed) {
        super(title, maxScore);
        this.videoMinutes = videoMinutes;
        this.playbackSpeed = playbackSpeed;
    }

    public void watch(int minutes) {
        watchedMinutes = Math.min(videoMinutes, watchedMinutes + minutes);
    }

    public double getPlaybackSpeed() {
        return playbackSpeed;
    }

    public void setPlaybackSpeed(double playbackSpeed) {
        this.playbackSpeed = playbackSpeed;
    }

    @Override
    public int estimateCompletionTime() {
        // оставшееся видео с учётом скорости + 10 мин на конспект
        int left = (int) Math.ceil((videoMinutes - watchedMinutes) / playbackSpeed);
        return left == 0 ? 0 : left + 10;
    }

    @Override
    public double getProgressPercent() {
        return 100.0 * watchedMinutes / videoMinutes;
    }

    @Override
    public String checkProgress() {
        return String.format("просмотрено %d из %d мин (%.0f%%)",
                watchedMinutes, videoMinutes, getProgressPercent());
    }

    @Override
    public String getModuleType() {
        return "Видеолекция";
    }
}
