package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() > oldest.getAge()) {
                oldest = students[i];
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int adultsCount = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].isAdult()) {
                adultsCount++;
            }
        }
        return adultsCount;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length == 0) {
            return Double.NaN;
        }
        double sum = 0;
        for (Student s : students) {
            sum += s.getGrade();
        }
        return sum / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        int n  = students.length;
        for (int i = 0; i < n - 1 ; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getGrade() < students[j + 1].getGrade()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student s : students) {
            if (s.getGrade() >= 15) {
                System.out.println(s.getName() + " ");
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j  = i + 1; j < students.length; j++) {
                if (students[i].getName().equalsIgnoreCase(students[j].getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] students1 = new Student[students.length + 1];
        for (int i  = 0; i < students.length; i++) {
            students1[i] = students[i];
        }
        students1[students.length] = newStudent;
        return students1;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(1, "John", 20, 12);
        arr[1] = new Student(2, "john", 19, 16);
        arr[2] = new Student(3, "Alice", 17, 18);
        arr[3] = new Student(4, "Dina", 22, 14);
        arr[4] = new Student(5, "Amine", 21, 10);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("\nOldest: " + oldest);

        // 3) Count adults
        int adultCount = countAdults(arr);
        System.out.println("Number of adults: " + adultCount);

        // 4) Average grade
        double avgGrade = averageGrade(arr);
        System.out.println("Average grade: " + avgGrade);

        // 5) Find by name
        Student found = findStudentByName(arr, "Alice");
        System.out.println("Alice found: " + found);

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr, 4, 19);
        // function
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        boolean duplicates = hasDuplicateNames(arr);
        System.out.println("\nDuplicates? " + duplicates);

        // 10) Append new student
        arr = appendStudent(arr, new Student(6, "Ahmed", 18, 17));
        System.out.println("\n=== After appending new student ===");
        for (Student s : arr) System.out.println(s);


        // 11) School
        Student[][] school = new Student[2][3];
        school[0][0] = new Student(1, "John", 20, 12);
        school[0][1] = new Student(2, "Alice", 19, 18);
        school[0][2] = new Student(3, "Bob", 21, 15);

        school[1][0] = new Student(4, "Dina", 22, 14);
        school[1][1] = new Student(5, "Amina", 21, 10);
        school[1][2] = new Student(6, "Sara", 20, 17);

        for (int i = 0 ; i < school.length; i++) {
            System.out.println("Class " + (i + 1) + ":");
            for (int j = 0; j < school[i].length; j++) {
                System.out.println(school[i][j].getName());
            }
        }
        for (int i = 0; i < school.length; i++) {
            Student topStudent = school[i][0];
            for (int j = 0; j < school[i].length; j++) {
                if (school[i][j].getGrade() > topStudent.getGrade()) {
                    topStudent = school[i][j];
                }
            }
            System.out.println("Top student in Class " + (i + 1) + ": " + topStudent.getName() + " with grade " + topStudent.getGrade());
        }

    }

}

