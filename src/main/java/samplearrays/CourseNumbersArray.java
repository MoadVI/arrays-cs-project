package samplearrays;

public class CourseNumbersArray {
    public static int[] addCourse(int[] registeredCourses, int courseNumber) {
        int [] updatedCourses = new int[registeredCourses.length + 1];
        for (int i = 0; i < registeredCourses.length; i++) {
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[updatedCourses.length - 1] = courseNumber;
        return updatedCourses;
    }
    public static void printCourses(int[] courses) {
        for (int i = 0; i < courses.length; i++) {
            System.out.println(courses[i]);
        }
    }
    public static boolean courseExist(int[] courses, int courseNumber) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == courseNumber) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        if (!courseExist(registeredCourses, 3000)) {
            registeredCourses = addCourse(registeredCourses, 3000);
        }

        printCourses(registeredCourses);
    }
}
