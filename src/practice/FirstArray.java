package practice;

import java.util.Arrays;

public class FirstArray {
    public static void main(String[] args) {

        Student stud[] = new Student[5];

        Student stud1 = new Student();
        stud1.setName("Juan", "Castaneda");
        stud1.setDob("12-47-79");
        stud1.setId("1234");

        stud[0] = stud1;

        for(int i = 0; i <= stud.length; i++) {
            System.out.println(Arrays.toString(stud));
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
