import java.util.Scanner;

public class PassStrengthCheck {
    public static void strengthCheck(String pass) {
        int n = pass.length();
        int m = 0;
        boolean hasSpec = false;
        boolean hasLow = false;
        boolean hasUp = false;
        boolean hasNum = false;
        
        //POOL
        String upStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowStr = "abcdefghijklmnopqrstuvwxyz";
        String specStr = "!@#$%^&*()";
        String numStr = "0123456789";

        if (n<8) {
            System.out.println("Category: POOR");
            System.out.println("Reason: Password must be at least 8 characters long.");
        }

        if(n>=8) {
            for(int i=0; i<pass.length(); i++) {
                char ch = pass.charAt(i);
                if(specStr.contains(String.valueOf(ch))) {
                    hasSpec=true;
                    
                }
                if (lowStr.contains(String.valueOf(ch))) {
                    hasLow=true;
                    
                }
                if (upStr.contains(String.valueOf(ch))) {
                    hasUp=true;
                }
                if (numStr.contains(String.valueOf(ch))) {
                    hasNum=true;
                }
            }
            if(hasSpec) m++;
            if(hasLow) m++;
            if(hasUp) m++;
            if(hasNum) m++;
            if (m == 4) {
                System.out.println("Category: STRONG");
                System.out.println("Your password contains uppercase, lowercase, numbers, and special characters.");
            }
            else if (m == 3) {
                System.out.println("Category: GOOD");
                System.out.println("Your password meets some of the criteria for a strong password.");
            } else {
                System.out.println("Poor");
            }   System.out.println("Reason: Password should include at least two of the following: " +
                               "uppercase letters, lowercase letters, numbers, or special characters.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Password: ");
        String pass = sc.next();
        strengthCheck(pass);
    }
}