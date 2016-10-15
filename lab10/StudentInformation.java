/**
 * Created by User on 10/14/2016.
 */
public class StudentInformation {
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    

    public StudentInformation() {
        //empty constructor

    }

    public StudentInformation(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel) {
        setStudentNumber(studentNumber);
        setFirstName(firstName);
        setMiddleInitial(middleInitial);
        setLastName(lastName);
        setCourse(course);
        setYearLevel(yearLevel);

    }

    @Override
    public String toString() {
        return "Student Number: " + studentNumber + "\n" +
               "Name: " + lastName + ", " + firstName + " " + middleInitial + ".\n" +
                "Program: " + course + "\n" +
                "Year Level: " + yearLevel;
    }
}