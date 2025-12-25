/**
 * JavaDoc: Represents Course in Year 2 IP.
 * 
 * Example: {@code Subject s = new Subject("Intro to SE", 3, 64)}
 * 
 * @author Theary
 * @author Partner
 * @version 1.0
 * @since 12/25/2025
 */
public class Subject {
    private String name;
    private int totalCredits = 1;
    public static final double MAX_ABSENCE_SCORE = 10.0;
    private int totalHours = 50;

    // FIXED: Parameter name typo "totalCrdits" → "totalCredits"
    public Subject(String name, int totalCredits, int totalHours) {
        setName(name);
        this.totalCredits = totalCredits;
        this.totalHours = totalHours;
    }

    public Subject() {
        this("No Subject is defined", 1, 50);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be null or empty.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    // FIXED: Parameter name typo
    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public String toString() {
        return String.format("%s (%d credits, %d hours)",
                name != null ? name : "Unnamed", totalCredits, totalHours);
    }

    /**
     * Calculate absence score: MAX_ABSENCE_SCORE - (absences/totalHours * 10)
     * 
     * @param absences number of absences
     * @return absence score (0 to 10)
     */
    public double calculateAbsenceScore(int absences) {
        if (totalHours == 0)
            return 0.0;
        // FIXED: Cast to double for correct division
        return MAX_ABSENCE_SCORE - (absences / (double) totalHours * 10);
    }

    public static void main(String[] args) {
        Subject sb = new Subject("Introduction to Software Engineering", 3, 64);
        System.out.println(sb); // Intro to SE (3 credits, 64 hours)
        System.out.println("Absence score: " + sb.calculateAbsenceScore(10)); // ~4.375
    }
}
