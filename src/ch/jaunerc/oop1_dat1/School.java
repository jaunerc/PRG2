/*
 * License header jaunerc
 */
package ch.jaunerc.oop1_dat1;

import java.util.HashMap;

/**
 *
 * @author jaunerc
 */
public class School {
    
    private String name;
    private HashMap<Integer, Student> studentList;
    
    public static void main(String[] args) {
        School school = new School("Tescht");
        school.littleTest();
    }
    
    public School(final String name) {
        this.name = name;
        studentList = new HashMap<>();
    }
    
    public void enrolStudent(final Student student) {
        studentList.put(student.getStudentNumber(), student);
    }
    
    public void printStudents() {
        System.out.println("Students: ");
        for(Student s : studentList.values()) {
            s.print();
        }
    }
    
    public void littleTest() {
        addDummyData();
        printStudents();
    }
    
    private void addDummyData() {
        enrolStudent(new Student("hans", "meier", "elo"));
        enrolStudent(new Student("stefu", "müller", "infi"));
        enrolStudent(new Student("ana", "habicht", "bwl"));
    }
    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

}
