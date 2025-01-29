//STUDENT COURSE REGISTRATION SYSTEM

import java.util.*;

class Course 
{
    String courseCode;
    String title;
    String description;
    int capacity;
    int enrolledStudents;
    String schedule;
    public Course(String courseCode, String title, String description, int capacity, String schedule) 
    {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.schedule = schedule;
    }
    public void displayCourseDetails() 
   {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled Students: " + enrolledStudents);
        System.out.println("Schedule: " + schedule);
        System.out.println("Available Slots: " + (capacity - enrolledStudents));
        System.out.println();
    }
    public boolean registerStudent()
   {
        if (enrolledStudents < capacity)
        {
            enrolledStudents++;
            return true;
        } 
        else {
            return false; 
        }
    }
    public boolean dropStudent() 
    {
        if (enrolledStudents > 0)
        {
            enrolledStudents--;
            return true;
        } 
        else 
	{
            return false; 
        }
    }
}

class Student 
{
    String studentID;
    String name;
    List<Course> registeredCourses;
    public Student(String studentID, String name)
    {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
    public void displayRegisteredCourses() 
    {
        if (registeredCourses.isEmpty()) 
        {
            System.out.println("No courses registered.");
        } 
        else
        {
            System.out.println("Registered Courses for " + name + ":");
            for (Course course : registeredCourses) 
            {
                System.out.println("Course Code: " + course.courseCode + ", Title: " + course.title);
            }
        }
    }
    public boolean registerForCourse(Course course) 
    {
        if (course.registerStudent()) 
        {
            registeredCourses.add(course);
            return true;
        } 
	else
        {
            System.out.println("Course " + course.courseCode + " is full.");
            return false;
        }
    }
    public boolean dropCourse(Course course) 
   {
        if (registeredCourses.contains(course)) 
	{
            if (course.dropStudent())
	    {
                registeredCourses.remove(course);
                return true;
            }
        }
        System.out.println("You are not registered for this course.");
        return false;
    }
}

public class Task5
{

    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        initializeCourses();
        while (true) 
  	{
            System.out.println("\nStudent Course Registration System \n");
            System.out.println("1. Register a Student");
            System.out.println("2. Display Available Courses");
            System.out.println("3. Register for a Course");
            System.out.println("4. Drop a Course");
            System.out.println("5. Display Registered Courses");
            System.out.println("6. Exit");
            System.out.print("Enter your option: ");
            int ch= s.nextInt();
            s.nextLine(); 
            switch (ch) 
	    {
                case 1:registerStudent(s);
                       break;
                case 2:displayAvailableCourses();
                       break;
                case 3:registerForCourse(s);
                       break;
                case 4:dropCourse(s);
                       break;
                case 5:displayRegisteredCourses(s);
                       break;
                case 6:System.out.println("Thank You!");
                       return;
                default:System.out.println("Invalid option. Please try again.");
             }
        }
    }
    private static void initializeCourses() 
    {
        courses.add(new Course("CS101", "Introduction to Computer Science", "Learn the basics of programming.", 3,
                       "Mon/Wed 10:00 AM - 12:00 PM"));
        courses.add(new Course("DS101", "Calculus I", " Learn Advanced Data Structures.", 2, "Tue/Thu 9:00 AM - 11:00 AM"));
        courses.add(new Course("PY101", "Python programming", "Study the concepts of python", 3, "Mon/Wed 2:00 PM - 4:00 PM"));
    }
    private static void registerStudent(Scanner s) 
    {
        System.out.print("Enter student ID: ");
        String studentID = s.nextLine();
        System.out.print("Enter student name: ");
        String name = s.nextLine();
        students.add(new Student(studentID, name));
        System.out.println("Student registered successfully.");
    }
    private static void displayAvailableCourses() 
    {
        System.out.println("\nAvailable Courses");
        for (Course course : courses)
        {
            course.displayCourseDetails();
        }
    }
    private static void registerForCourse(Scanner s)
    {
        System.out.print("Enter student ID: ");
        String studentID = s.nextLine();
        Student student = findStudent(studentID);
        if (student == null) 
        {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter course code to register for: ");
        String courseCode = s.nextLine();
        Course course = findCourse(courseCode);
        if (course == null)
        {
            System.out.println("Course not found!");
            return;
        }

        if (student.registerForCourse(course)) 
        {
            System.out.println("You have successfully registered for " + course.title);
        }
    }
    private static void dropCourse(Scanner s) 
    {
        System.out.print("Enter student ID: ");
        String studentID = s.nextLine();
        Student student = findStudent(studentID);
        if (student == null) 
        {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter course code to drop: ");
        String courseCode = s.nextLine();
        Course course = findCourse(courseCode);
        if (course == null) 
       {
            System.out.println("Course not found!");
            return;
        }

        if (student.dropCourse(course)) 
        {
            System.out.println("You have successfully dropped " + course.title);
        }
    }
    private static void displayRegisteredCourses(Scanner s) 
    {
        System.out.print("Enter student ID: ");
        String studentID = s.nextLine();
        Student student = findStudent(studentID);
        if (student == null) 
        {
            System.out.println("Student not found!");
            return;
        }
        student.displayRegisteredCourses();
    }
    private static Student findStudent(String studentID) 
    {
        for (Student student : students)
        {
            if (student.studentID.equals(studentID))
            {
                return student;
            }
        }
        return null;
    }
    private static Course findCourse(String courseCode)
    {
        for (Course course : courses)
        {
            if (course.courseCode.equals(courseCode))
            {
                return course;
            }
        }
        return null;
    }
}
