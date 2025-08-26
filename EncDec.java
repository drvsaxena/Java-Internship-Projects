import java.io.*;
import java.util.Scanner;

public class EncDec {
    public static String xorEncDec(String text) {
        String key = "SECRET";
        StringBuilder xorsb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            char enc = (char) (ch ^ key.charAt(i % key.length()));
            xorsb.append(enc);
        }

        return xorsb.toString();
    }

    public static void encryptFile(String inpfl,String outfl) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inpfl));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outfl));

            String line;
            while((line = reader.readLine()) != null) {
                String encryptline = xorEncDec(line);
                writer.write(encryptline);
                writer.newLine();
            }
            reader.close();
            writer.close();
            
            System.out.println("File encrypted successfully!");
        }       
        catch (IOException e) {
            System.out.println("Error encrypting file: " + e.getMessage());
        }
    }

    
    public static void decryptFile(String inpfl,String outfl) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inpfl));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outfl));

            String line;
            while((line = reader.readLine()) != null) {
                String dycryptline = xorEncDec(line);
                writer.write(dycryptline);
                writer.newLine();
            }
            reader.close();
            writer.close();
            
            System.out.println("File decrypted successfully!");
        }       
        catch (IOException e) {
            System.out.println("Error decrypting file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
   
        System.out.println("=========== ENCRYPTION / DYCRYPTION PROGRAM ===========");
        System.out.println("1 -> Encryption");
        System.out.println("2 -> Dycryption");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.println();
        System.out.print("Enter input file name: ");
        String inpfl = sc.next();
        System.out.print("Enter output file name: ");
        String outfl = sc.next();

        File file = new File(inpfl);
        if (!file.exists()) {
            System.out.println("Error: File not exists");
            return;
        }
        
        System.out.println();
        if (choice == 1) {
            encryptFile(inpfl,outfl);
        } 
        else if (choice == 2) {
            decryptFile(inpfl,outfl);
        } else {
            System.out.println("Invalid choice!");
        }
    }   
}