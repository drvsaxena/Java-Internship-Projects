import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedStr.length() - 1;
        
        while(left<right) {
            if(cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();
        if(isPalindrome(str)) {
            System.out.println(str+" is Palindrome");
        } else {
            System.out.println(str+" is not Palindrome");
        }
        sc.close();
    }
}
