import java.util.*;

public class PassGenerator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of password: ");
        int len = sc.nextInt();
        System.out.println();

        System.out.print("Include numbers (Y/N): ");
        String choice1 = sc.next();
        boolean num =  choice1.toUpperCase().equals("Y");

        System.out.print("Include lowercase letters (Y/N): ");
        String choice2 = sc.next();
        boolean lowalpha =  choice2.toUpperCase().equals("Y");
        
        System.out.print("Include uppercase letters (Y/N): ");
        String choice3 = sc.next();
        boolean upalpha =  choice3.toUpperCase().equals("Y");
        
        System.out.print("Include special characters (Y/N): ");
        String choice4 = sc.next();
        boolean spec =  choice4.toUpperCase().equals("Y");

        String numbers = "0123456789";
        String lalphabets = "abcdefghijklmnopqrstuvwxyz";
        String ualphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()";

        StringBuilder pool = new StringBuilder();
        
        if(num) {
            pool.append(numbers);
        }
        if(lowalpha) {
            pool.append(lalphabets);
        }
        if(upalpha) {
            pool.append(ualphabets);
        }
        if(spec) {
            pool.append(special);
        }

        if (pool.length() == 0) {
            System.out.println("Error: At least one character type must be selected.");
            sc.close();
            return;
        }

        StringBuilder pass = new StringBuilder();
        Random ran = new Random();
        for(int i=0; i<len; i++) {
            int numind = ran.nextInt(pool.length());
            char numchar = pool.charAt(numind);
            pass.append(numchar);
        }

        System.out.println("Your generated password: " + pass.toString());
        sc.close();
    }
}