package cod;

import java.util.Scanner;

public class CurrencyCoverter {

    // Function to convert from one currency to another
    public static double convert(double amount, double rate) {
        return amount * rate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define some example exchange rates
        double usdToEurRate = 0.85; // Example rate: 1 USD = 0.85 EUR
        double eurToUsdRate = 1.18; // Example rate: 1 EUR = 1.18 USD
        double usdToGbpRate = 0.75; // Example rate: 1 USD = 0.75 GBP
        double gbpToUsdRate = 1.33; // Example rate: 1 GBP = 1.33 USD
        double UsdToinrRate = 83.4195;
        double inrToUsdRate = 0.012;
        double inrTokwdRate = 0.00366;
        // User input for amount
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        // User input for currency conversion choice
        System.out.println("Choose conversion:");
        System.out.println("1: USD to EUR");
        System.out.println("2: EUR to USD");
        System.out.println("3: USD to GBP");
        System.out.println("4: GBP to USD");
        System.out.println("5: USD to INR");
        System.out.println("6: INR to USD");
        System.out.println("7: INR to KWD");
        
        int choice = scanner.nextInt();

        double convertedAmount = 0;

        switch (choice) {
            case 1:
                convertedAmount = convert(amount, usdToEurRate);
                System.out.println(amount + " USD is " + convertedAmount + " EUR");
                break;
            case 2:
                convertedAmount = convert(amount, eurToUsdRate);
                System.out.println(amount + " EUR is " + convertedAmount + " USD");
                break;
            case 3:
                convertedAmount = convert(amount, usdToGbpRate);
                System.out.println(amount + " USD is " + convertedAmount + " GBP");
                break;
            case 4:
                convertedAmount = convert(amount, gbpToUsdRate);
                System.out.println(amount + " GBP is " + convertedAmount + " USD");
                break;
            case 5:
                convertedAmount = convert(amount, UsdToinrRate);
                System.out.println(amount + " USD is " + convertedAmount + " INR");
                break;
            case 6:
                convertedAmount = convert(amount, inrToUsdRate);
                System.out.println(amount + " INR is " + convertedAmount + " USD");
                break;
            case 7:
                convertedAmount = convert(amount, inrTokwdRate);
                System.out.println(amount + " INR is " + convertedAmount + " KWD");
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
