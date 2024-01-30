package LEQ2;

import java.util.Collections;
import java.util.Vector;

public class Yakesh_SortNameAndGrade {

    public static void main(String[] args) {
        //assigning variables
        myHeader(6,2);
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26)};
//creating new vector and setting all values
        Vector<StudentGrade> sg = new Vector<>();
        for (int i = 0; i < fnArray.length; i++){
            sg.add(new StudentGrade(fnArray[i],lnArray[i], grd[i]));
        }
        //printing unsorted array
        System.out.print("\n\nUnsorted Array... \n");
        for(int i = 0; i<sg.size(); i++){
            System.out.printf("%22s",sg.get(i).toString());
        }
        //printing array sorted using Collection
        Collections.sort(sg);
        System.out.print("\n\nSorted by Grades... \n");
        for(int i = 0; i<sg.size(); i++){
            System.out.printf("%22s",sg.get(i).toString());
        }
        //new array with all students
        StudentGrade[] array = new StudentGrade[fnArray.length];
        sg.copyInto(array);//copying from vector to array
        //printing array sorted by first names
        sort(array,1);
        System.out.print("\n\nSorted by First Names... \n");
        printArray(array);
        //printing array sorted by lastnames
        sort(array,2);
        System.out.print("\n\nSorted by Last Names... \n");
        printArray(array);
        myFooter(6,2);

    }

    public static void sort(StudentGrade[] a, int x) {//pulls each integer and compares with all elements to left of it
        //fills array with first or last names based on x
        String[] nameArray = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            if (x == 1) {
                nameArray[i] = a[i].getFirstName();
            } else {
                nameArray[i] = a[i].getLastName();
            }
        }
        //sorts names in array using insertion algorithm
        int i = 0, j = 0;
        for( i = 1; i < a.length; i++){
            String key = nameArray[i];//element going to be compared with
            StudentGrade studentKey = a[i];
            for(j=i-1; j>=0 && nameArray[j].compareTo(key) > 0;j--){//comparing all elements to lower indexes
              //swapping both names array and original array
                a[j+1] = a[j];//swapping if lower number is found
                nameArray[j+1] = nameArray[j];
            }
            a[j+1] = studentKey;
            nameArray[j+1] = key;
        }
    }

    public static void printArray(StudentGrade[] a){//print all elements of array
        for(int i =0; i < a.length; i++){
            System.out.printf("%22s",a[i].toString());
        }
    }

    public static void myHeader(int lab_number, int q_number){//Header method
        System.out.printf("=======================================================\n" +
                "Lab Exercise %d-Q%d\n" +
                "Name: Yakesh Umachandran\n" +
                "Student Number: 251303571\n" +
                "Goal of this Exercise: Using different sorting algorithms to sort data\n" +
                "=======================================================",lab_number, q_number);
    }
    public static void myFooter(int lab_number, int q_number){//Footer Method
        System.out.printf("\n=======================================================\n" +
                "Completion of Lab Exercise %d-Q%d is successful!\n" +
                "Signing off - Yakesh\n" +
                "=======================================================", lab_number,q_number);
    }
}