import java.util.Scanner;

public class codsoft_task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter the number of subjects: ");
        int no_of_subjects = sc.nextInt();
        
        int[] marks = new int[no_of_subjects];
        int totalMarks = 0;
        
        for (int i = 0; i < no_of_subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
            
            
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input. Marks should be between 0 and 100.");
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                marks[i] = sc.nextInt();
            }
            
            totalMarks += marks[i];
        }
        
        
        double avg_percentage = (double) totalMarks / no_of_subjects;
        
       
        String grade;
        if (avg_percentage >= 90) {
            grade = "A+";
        } else if (avg_percentage >= 80) {
            grade = "A";
        } else if (avg_percentage >= 70) {
            grade = "B";
        } else if (avg_percentage >= 60) {
            grade = "C";
        } else if (avg_percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        
        System.out.println("\n---** Results **---");
        System.out.println("Total Marks you have got: " + totalMarks);
        System.out.println("Average Percentage is : " + avg_percentage + "%");
        System.out.println("Grade is: " + grade);
        
        sc.close();
    }
}
