/**
 * JavaDoc: Represents Course in Year 2 IP.
 * 
 * Example: {@code Subject s = new Subject()}
 * 
 * @author Theary
 * @author Partner
 * @since 12/25/2025
 */

class Subject {
    private String name;
    private int totalCredits = 1;
    public static final double MAX_ABSENCE_SCORE = 10;
    private int totalHours = 50;

    @Override
    public String toString() {
        return String.format("%s (%d credits, %d hours)", name, totalCredits, totalHours);
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
        Subject sb = new Subject();
        sb.name = "Introduction to Software Engineering";
        sb.totalCredits = 3;
        sb.totalHours = 64;

        System.out.println(sb);
        System.out.println("Absence score: " + sb.calculateAbsenceScore(10));
    }
}