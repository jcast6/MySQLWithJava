package practice;

public class Student {
    public String first_name;
    public String last_name;
    public String dob;
    public String id;

    //default constructor
    public Student() {
    }

    public Student(String first_name, String last_name, String dob, String id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob  = dob;
        this.id = id;
    }

    public void setName(String first_name, String lName) {
        this.first_name  = first_name;
        this.last_name = lName;
    }

    public void setDob(String date) {
        this.dob = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDob() {
        return dob;
    }

    public String getId() {
        return id;
    }


    public void displayAllStudents(Student stud[]) {
        System.out.println("All Students: \n");
        System.out.println("Student id: " + id + " "
                + "\nStudent name: "
                + first_name + " " + last_name
                + "\nD.O.B: " + dob);
        System.out.println();
    }

}
