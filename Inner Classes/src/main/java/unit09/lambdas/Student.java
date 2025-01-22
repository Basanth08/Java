package unit09.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A class that represents a student with a first and last na
 */
public class Student implements Comparable<Student> { // remove Comparable
    /**
     * The student's first name.
     */
    private final String firstName;

    /**
     * The student's last name.
     */
    private final String lastName;

    /**
     * Creates a new student.
     * 
     * @param firstName The new student's first name.
     * @param lastName The new student's last name.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Student other) {
        return this.firstName.compareTo(other.firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" + this.lastName + ", " + this.firstName + "}";
    }

    private static int compareByFirstName (Student a, Student b) {
        return a.firstName.compareTo (b.firstName);
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<> ();
        students.add (new Student ("Bruce", "Herring"));
        students.add (new Student ("Bobby", "St. Jacques"));
        students.add (new Student ("Dave", "Patrick"));
        students.add (new Student ("Chris", "Wake"));

        System.out.println (students);

        // Anonymous Class
        students.sort (new Comparator<Student>() {
            @Override
            public int compare (Student o1, Student o2) {
                return o1.lastName.compareTo (o2.lastName);    
            }
        });
        System.out.println (students);

        // Lambda 1
        students.sort ((Student o1, Student o2) -> {
            return o2.lastName.compareTo (o1.lastName);    
        });
        System.out.println (students);

        // Lambda 2
        students.sort ((o1, o2) -> o2.firstName.compareTo (o1.firstName));
        System.out.println (students);

        // Lambda 3
        students.sort (Student::compareByFirstName);
        System.out.println (students);

        students.stream ().forEach (
            student -> System.out.println (student.firstName + " " + student.lastName));

        students.stream ().filter (student -> student.firstName.toLowerCase ().contains ("c")).
            forEach (System.out::println);
    }
}