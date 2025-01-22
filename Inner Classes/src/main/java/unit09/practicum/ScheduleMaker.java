package unit09.practicum;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Greedy algorithm for selecting the courses to maximize the number of courses taken.

PseudoCode:
1.Sort the courses by end time in ascending order
2.Initialize an empty list to store the selected courses
3.Select the first course (with the earliest end time) and add it to the list
4.Iterate through the remaining courses:
    - If the current course's start time is greater than or equal to the end time of the last selected course:
    - Add the current course to the list of selected courses\
5.Return the list of selected courses
 */

public class ScheduleMaker {
    public static List<Course> makeSchedule(List<Course> courses) {
        // Sort the courses by end time in ascending order
        courses.sort(Comparator.comparing(Course::getEnd));
        
        List<Course> selectedCourses = new ArrayList<>();
        
        // Select the first course (with the earliest end time)
        selectedCourses.add(courses.get(0));
        
        // Iterate through the remaining courses
        for (int i = 1; i < courses.size(); i++) {
            Course currentCourse = courses.get(i);
            Course lastSelectedCourse = selectedCourses.get(selectedCourses.size() - 1);
            
            // If the current course's start time is greater than or equal to the end time of the last selected course
            if (currentCourse.getStart() >= lastSelectedCourse.getEnd()) {
                // Add the current course to the list of selected courses
                selectedCourses.add(currentCourse);
            }
        }
        
        return selectedCourses;
    }
}