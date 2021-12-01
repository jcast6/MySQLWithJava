package practice;

public class StudentTest {
    public static void main(String[] args) {
        Student stud1 = new Student();

        stud1.setName("Jane", "Doe");
        stud1.setDob("11-12-1955");
        stud1.setId("1234");

        System.out.println(stud1.arraysToString(stud1));

    }
}
