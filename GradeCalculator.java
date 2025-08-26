import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of grades you want to enter: ");
        int numGrade = sc.nextInt();
        double sum = 0.0;
        System.out.println("Enter Grades:");
        for(int i=1; i<=numGrade; i++) {
            double grade = sc.nextDouble();
            sum = grade+sum;
        }
        double avg = sum / numGrade;
        System.out.printf("Average marks: %.2f", avg);
        sc.close();
    }
    
}
