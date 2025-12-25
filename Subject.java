/**
 * Class Name: Subject
 * Description: Represents a Year 2 course in the program
 * Author: Your Name
 * Date: 2025-xx-xx
 */
public class Subject {

    // Constant (allowed global variable)
    public static final int DEFAULT_TOTAL_HOURS = 50;

    // Instance variables (not global)
    private String name;
    private int totalCredits;
    private int totalHours;

    // Constructor
    public Subject(String name, int totalCredits) {
        setName(name);
        this.totalCredits = totalCredits;
        this.totalHours = DEFAULT_TOTAL_HOURS;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be null or empty.");
        }
        this.name = name;
    }
}
