import java.util.*;

public class TempConverter {

    public static double farToCelConvert(double temp) {
        double value = (temp-32)/1.8;
        return value;
    }

    
    public static double celToFarConvert(double temp) {
        double value = (temp*1.8) + 32;
        return value;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in figures only: ");
        double temp = sc.nextDouble();
        System.out.print("Enter unit (C/F): ");
        String choice = sc.next();

        if (choice.toUpperCase().equals("F")) {
            double convertedTemp = farToCelConvert(temp);
            System.out.printf("%.1f Farenhiet is %.1f Celcius",temp,convertedTemp);
        }
        else if (choice.toUpperCase().equals("C")) {
            double convertedTemp = celToFarConvert(temp);
            System.out.printf("%.1f Celcius is %.1f Farenhiet", temp, convertedTemp);
        }
        else {
            System.out.println("Invalid input");
        }
        sc.close();
    }
}