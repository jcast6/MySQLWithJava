package sys_and_des_proj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Register {

    public static void main(String[] args) {

        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        while (true) {
            System.out.println("1: Register Student");
            System.out.println("2: Add course");
            System.out.println("3: View available courses");
            System.out.println("4: Enroll Student with course");
            System.out.println("5: Drop enrollment");
            System.out.println("6: close");
            System.out.println("enter choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Student name");
                    String name = text.nextLine();
                    int id = students.size() + 1;
                    Student s = new Student(id, name);
                    students.add(s);
                    System.out.println("Student registered with name " + s.getName() + " and with id " + s.getId());
                    break;
                case 2:
                    System.out.println("enter course name");
                    String cname = text.nextLine();
                    int cid = courses.size() + 1;
                    Course c = new Course(cid, cname);
                    courses.add(c);
                    System.out.println("Course with name " + c.getTitle() + " and with id " + c.getId() + " is created");
                    break;
                case 3:
                    for (Course cr : courses) {
                        System.out.println(cr.getTitle() + " " + ", course id: " + cr.getId());
                    }
                    break;
                case 4:
                    System.out.println("enter student id ");
                    int sid = sc.nextInt();
                    Student foundStudent = new Student();
                    int flaag = 0;
                    for (Student s1 : students) {
                        if (s1.getId() == sid) {
                            foundStudent = s1;
                            flaag++;
                            break;
                        }
                    }
                    if (flaag == 0) {
                        System.out.println("the student is not registered. Register the student first");
                    } else {
                        System.out.println("Enter course id");
                        int cid1 = sc.nextInt();
                        Course foundCourse = new Course();
                        int cflaag = 0;
                        for (Course c2 : courses) {
                            if (c2.getId() == cid1) {
                                foundCourse = c2;
                                cflaag++;
                                break;
                            }
                        }
                        if (cflaag == 0) {
                            System.out.println("the course is not registered.Register the course first");
                        } else {
                            Enrollment newEnroll = new Enrollment();
                            newEnroll.enroll(foundStudent, foundCourse);
                        }
                    }
                    break;
                case 5:
                    System.out.println("enter student id ");
                    int sid1 = sc.nextInt();
                    Student foundStudent1 = new Student();
                    int flaag1 = 0;
                    for (Student s1 : students) {
                        if (s1.getId() == sid1) {
                            foundStudent1 = s1;
                            flaag1++;
                            break;
                        }
                    }
                    if (flaag1 == 0) {
                        System.out.println("the student is not registered. Register the student first");
                    } else {
                        //System.out.println(foundStudent1.getName());
                        Enrollment deroll = new Enrollment();
                        deroll.deEnroll(foundStudent1);
                    }
                    break;
                case 6:
                    System.exit(0);
            }

        }

    }
}

class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }

}

class Course {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course(int id, String title) {
        super();
        this.id = id;
        this.title = title;
    }

    public Course() {
        super();

    }

    @Override
    public String toString() {
        return "Courses [id=" + id + ", title=" + title + "]";
    }

}

class Enrollment {
    private static HashMap<Student, Course> enrollRegister = new HashMap<Student, Course>();

    Enrollment() {

    }

    public void enroll(Student s, Course c) {
        if (enrollRegister.containsKey(s)) {
            System.out.println("Student " + s.getName() + " with id " + s.getId() + " is already registered to course " + enrollRegister.get(s).getTitle());
        } else {
            enrollRegister.put(s, c);
            System.out.println("student " + s.getName() + " is enrolled with course " + c.getTitle());
        }
    }

    public void deEnroll(Student s) {
        //System.out.println(s.getName());
        if (enrollRegister.containsKey(s)) {
            enrollRegister.remove(s);
            System.out.println("Student with name " + s.getName() + " enrollment is cancelled");
        } else {
            System.out.println("the student is not enrolled");
        }
    }
}