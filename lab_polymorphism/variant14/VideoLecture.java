package lab_polymorphism.variant14;

// Videolektsiya: progress po prosmotrennym minutam
public class VideoLecture extends CourseModule {
    private final int videoMinutes;   // dlitelnost video
    private int watchedMinutes;       // prosmotreno minut
    private double playbackSpeed;     // skorost vosproizvedeniya

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
        // ostavsheesya video s uchyotom skorosti + 10 min na konspekt
        int left = (int) Math.ceil((videoMinutes - watchedMinutes) / playbackSpeed);
        return left == 0 ? 0 : left + 10;
    }

    @Override
    public double getProgressPercent() {
        return 100.0 * watchedMinutes / videoMinutes;
    }

    @Override
    public String checkProgress() {
        return String.format("prosmotreno %d iz %d min (%.0f%%)",
                watchedMinutes, videoMinutes, getProgressPercent());
    }

    @Override
    public String getModuleType() {
        return "Videolektsiya";
    }
}
