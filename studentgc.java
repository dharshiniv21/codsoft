package dharsh_new;

import java.util.Scanner;

public class studentgc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the student's name
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        
        // Ask for the scores in different subjects
        System.out.print("Enter the score for Mathematics: ");
        double mathScore = scanner.nextDouble();

        System.out.print("Enter the score for Science: ");
        double scienceScore = scanner.nextDouble();

        System.out.print("Enter the score for English: ");
        double englishScore = scanner.nextDouble();
        
        System.out.print("Enter the score for Tamil: ");
        double tamilScore = scanner.nextDouble();
        
        System.out.print("Enter the score for Social: ");
        double socialScore = scanner.nextDouble();
        
        // Calculate the average score
        double averageScore = (mathScore + scienceScore + englishScore+tamilScore+socialScore) / 5;
        
        // Determine the grade based on the average score
        char grade;
        if (averageScore >= 90) {
            grade = 'A';
        } else if (averageScore >= 80) {
            grade = 'B';
        } else if (averageScore >= 70) {
            grade = 'C';
        } else if (averageScore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        // Output the student's name, average score, and grade
        System.out.println("\nStudent: " + name);
        System.out.println("Average Score: " + averageScore);
        System.out.println("Grade: " + grade);

        // Close the scanner
        scanner.close();
    }
}
