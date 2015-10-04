/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.oop1_dat1;

/**
 *
 * @author jaunerc
 */
public class Teacher extends Person{
    
    private String subject;
    private int salary;
    
    public Teacher(final String name, final String firstName, final String subject, final int salary) {
        super(name, firstName);
        this.subject = subject;
        this.salary = salary;
    }
    
    public Teacher(final String name, final String firstName) {
        this(name, firstName, "", 0);
    }
    
    @Override
    public void print() {
        super.print();
        System.out.println(" - subject: "+subject+" - salary: "+salary);
    }
    
    /**
     * Get the value of salary
     *
     * @return the value of salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Set the value of salary
     *
     * @param salary new value of salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Get the value of subject
     *
     * @return the value of subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the value of subject
     *
     * @param subject new value of subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

}
