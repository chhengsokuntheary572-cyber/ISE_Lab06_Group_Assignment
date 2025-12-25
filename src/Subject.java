/**
 * JavaDoc: Represents Course in Year 2 IP.
 * 
 * Example: {@code Subject s = new Subject()}
 * 
 * @author Theary
 * @author Partner
 * @since 12/25/2025
 */

public class Subject {
    private String name;
    private int totalCredits = 1;
    public static final double MAX_ABSENCE_SCORE = 10.0;
    private int totalHours = 50;

    public Subject(String name, int totalCrdits, int totalHours) {
        setName(name);
        this.totalCredits = totalCrdits;
        this.totalHours = totalHours;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be null or empty.");
        }
        this.name = name.trim();
    }

    public Subject() {
        this("No Subject is defined", 1, 50)
    }

    public String getName() {return name;}
    public int getTotalCredits() {return totalCredits;}
    public void setTotalCredits(int totalCrdits) {this.totalCredits = totalCrdits;}
    public int getTotalHours() { return totalHours;}
    public void setTotalHours(int totalHours) {this.totalHours = totalHours;}

    @Override
    public String toString() {
        return String.format("%s (%d credits, %d hours)", name != null ? name : "Unnamed", totalCredits, totalHours);
    }

    /**
     * Find the scores of absences.
     * 
     * @param absence number of absence
     * @return absence score
     */

    public double calculateAbsenceScore(int absences) {
        // if totalHours = 10, absneces = 2 => score = 8
        // if totalHours = 64, absences = 10 => score = ?

        return MAX_ABSENCE_SCORE - (absences / totalHours * 10);
    }

    public static void main(String[] args) {
        Subject sb = new Subject("Introduction to Software Engineering", 3, 64);

        System.out.println(sb);
        System.out.println("Absence score: " + sb.calculateAbsenceScore(10));
    }
}