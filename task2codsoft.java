package javaCodsoft;

import java.util.Scanner;

public class task2codsoft {
    public static void main(String[] args) {

        // Scanner class's object to read input from console
        Scanner sc = new Scanner(System.in);

        // Taking input from user and storing in its noOfsubject variable
        System.out.println("Enter the Number Of Subjects");
        int noOfSubject = sc.nextInt();


         ///Array to store marks of every subjects
        int[] subjectMarks = new int[noOfSubject];
        int totalMarks = 0;

        // Taking marks as a input for all individual subjects
        for (int i = 0; i < noOfSubject; i++) {
            System.out.println("Enter Marks Obtained in Subject" + (i + 1) + "(out of 100)");
            subjectMarks[i] = sc.nextInt();
            // checking the entered marks
            if (subjectMarks[i] < 0 || subjectMarks[i] > 100) {
                System.out.println("Invalid marks entered.Marks should be between 0 and 100");
                i--;
            } else {
                totalMarks += subjectMarks[i];
            }
        }

        //// Average Marks Calculation
        double average = (double) totalMarks / noOfSubject;

        /// Calculating Grade
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Displaying the Result
        System.out.println("Total Marks:"  +totalMarks);
        System.out.println("Average Percentage:"  +average);
        System.out.println("Grade:"  +grade);

        sc.close();
    }
}
