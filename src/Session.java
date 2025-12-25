/**
 * Represents daily study session with time validation.
 * 
 * Example: {@code Session session = new Session("Java Lab", 13, 15);}
 * 
 * @author Partner (driver)
 * @author Theary (navigator)
 * @version 1.0
 * @since 12/25/2025
 */
public class Session {
    private static final int MIN_DURATION_MINUTES = 30; // FIXED: Typo MMIN → MIN
    private String topic;
    private int startTime;
    private int endTime;
    private String room;

    public Session(String topic, int startTime, int endTime) {
        setTopic(topic); // Add validation
        setDuration(startTime, endTime);
        this.room = room;
    }

    // Add topic setter with validation
    public void setTopic(String topic) {
        if (topic == null || topic.trim().isEmpty()) {
            throw new IllegalArgumentException("Topic cannot be null or empty");
        }
        this.topic = topic.trim();
    }

    /**
     * Sets session duration with validation.
     * 
     * @param startTime 0-23 (hour)
     * @param endTime   0-23 (hour), must > startTime
     * @throws IllegalArgumentException if invalid times
     */
    public void setDuration(int startTime, int endTime) {
        if (startTime < 0 || startTime > 23 || endTime < 0 || endTime > 23 || startTime >= endTime) {
            throw new IllegalArgumentException("Invalid times: startTime < endTime, both 0-23");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTopic() {
        return topic;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return String.format("%s: %02d:00 - %02d:00", topic, startTime, endTime);
    }

    public static void main(String[] args) {
        Session session = new Session("Coding Standards Lab", 13, 15);
        System.out.println(session); // Coding Standards Lab: 13:00 - 15:00

        // Test exception
        try {
            new Session("Test", 15, 13); // Invalid: start >= end
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
