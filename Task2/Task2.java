package CodSoft;

import java.util.*;

public class Task2 {

    private final String name;
    private final double marks;
    private final char grade;

    public Task2(String name, double marks) {
        this.name = name;
        this.marks = marks;
        this.grade = gradeCalculate((int) marks);
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public char gradeCalculate(int marks) {
        if (marks >= 90 && marks <= 100) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else if (marks >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }
        public char getGrade() {
            return grade;
    }
        public static void main (String[]args){
            final String RED = "\033[31m";
            final String RESET = "\033[0m";

            Scanner sc = new Scanner(System.in);
            int s1, s2, s3, s4, s5, s6;

            System.out.print("Enter Student Name: ");
            String studentName = sc.nextLine();

            System.out.print("Enter 1st subject marks: ");
            s1 = sc.nextInt();
            while (s1 > 100 || s1 < 0) {
                System.out.println(RED + "\nPlease Enter valid marks!!!\n" + RESET);

                System.out.print("Enter 1st subject marks: ");
                s1 = sc.nextInt();
            }
            System.out.print("Enter 2nd subject marks: ");
            s2 = sc.nextInt();
            while (s2 > 100 || s2 < 0) {
                System.out.println(RED + "\nPlease Enter valid marks!!!\n" + RESET);

                System.out.print("Enter 2nd subject marks: ");
                s2 = sc.nextInt();
            }
            System.out.print("Enter 3rd subject marks: ");
            s3 = sc.nextInt();
            while (s3 > 100 || s3 < 0) {
                System.out.println(RED + "\nPlease Enter valid marks!!!\n" + RESET);

                System.out.print("Enter 3rd subject marks: ");
                s3 = sc.nextInt();
            }
            System.out.print("Enter 4th subject marks: ");
            s4 = sc.nextInt();
            while (s4 > 100 || s4 < 0) {
                System.out.println(RED + "\nPlease Enter valid marks!!!\n" + RESET);

                System.out.print("Enter 4th subject marks: ");
                s4 = sc.nextInt();
            }
            System.out.print("Enter 5th subject marks: ");
            s5 = sc.nextInt();
            while (s5 > 100 || s5 < 0) {
                System.out.println(RED + "\nPlease Enter valid marks!!!\n" + RESET);

                System.out.print("Enter 5th subject marks: ");
                s5 = sc.nextInt();
            }
            System.out.print("Enter 6th subject marks: ");
            s6 = sc.nextInt();
            while (s6 > 100 || s6 < 0) {
                System.out.println(RED + "\nPlease Enter valid marks!!!\n" + RESET);

                System.out.print("Enter 6th subject marks: ");
                s6 = sc.nextInt();
            }

            int totalMarks = s1 + s2 + s3 + s4 + s5 + s6;
            double averagePercentage = (double) totalMarks / 6;
            averagePercentage = Math.round(averagePercentage * 100.0) / 100.0;


            Task2 student = new Task2(studentName, averagePercentage);
            System.out.println();

            System.out.println("Name: " + student.getName());
            System.out.println("Total Marks Obtained: " + totalMarks + "/600");
            System.out.println("Average Percentage: " + student.getMarks() + "%");
            System.out.println("Grade: " + student.getGrade());
        }
    }
