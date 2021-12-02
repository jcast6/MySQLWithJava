package practice;

public class FirstArray {
    public static void main(String[] args) {

        //Create the Student objects with attributes.
        Student s1 = new Student();
        s1.setName("Juan", "Castaneda");
        s1.setDob("12-2-04");
        s1.setId("1111");

        Student s2=  new Student();
        s2.setName("Paul", "Lopez");
        s2.setDob("10-3-04");
        s2.setId("2222");

        Student s3 = new Student();
        s3.setName("Reese", "Garcia");
        s3.setDob("04-05-04");
        s3.setId("3333");

        //Create the array with objects.
        Student stud[] = {s1, s2, s3 };

        //Use for each loop to iterate through the array of objects and print the data using displayAllStudents() method.
        System.out.println("Displaying all Students: ");
        for(Student s : stud) {
            s.displayAllStudents(stud);
        }



/*
        //declaring an array
        int intArray[];

        //Allocating memory to array
        intArray = new int[20];

        //Combining both previous statements

        //int[] intArray = new int[20]

        // Array Literal
        // declaring an array literal
        int[] literalArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Accessing an array
        for(int i = 0; i < literalArray.length; i++) {
            System.out.println("index: " + i + ", element : " + literalArray[i]);
        }

 */

    }
}
