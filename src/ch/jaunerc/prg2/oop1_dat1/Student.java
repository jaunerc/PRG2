/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.oop1_dat1;

/**
 *
 * @author jaunerc
 */
public class Student extends Person {
    
    private static int number = 1000;

    private int studentNumber;
    private String course;
    
    /**
     * Get the value of number
     *
     * @return the value of number
     */
    public static int getNumber() {
        return number;
    }
    
    /**
     * Create a new Student.
     * @param name of the student
     * @param firstName of the student
     * @param course of the student
     */
    public Student(final String name, final String firstName, final String course) {
        super(name, firstName);
        this.course = course;
        studentNumber = number;
        number++;
    }
    
    /**
     * Create a new Student. Sets the course to an empty string.
     * @param name of the student
     * @param firstName of the student
     */
    public Student(final String name, final String firstName) {
        this(name, firstName, "");
    }
    
    @Override
    public void print() {
        super.print();
        System.out.println(" - course: - "+course);
    }
    
    /**
     * Get the value of course
     *
     * @return the value of course
     */
    public String getCourse() {
        return course;
    }

    /**
     * Set the value of course
     *
     * @param course new value of course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Get the value of studentNumber
     *
     * @return the value of studentNumber
     */
    public int getStudentNumber() {
        return studentNumber;
    }
}
