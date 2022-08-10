/**
 * This is a mortgage calculator program
 * that calculates a fixed rate mortgage payment and prints out an
 * amortization table on the screen.
 * @author: Justine Stroup
 * @version: 03/06/2020
 */

import java.util.Scanner;
public class JustineStroupProj05
{
   public static void main(String[] args)
   {
       // Create Scanner object
       Scanner input = new Scanner(System.in);
       
       // Declare necessary variables
       int principle, termInYears, count;
       double interestRate, monthlyPayment, totalInterest, balance;
       char answer;
       
       do
       {
           // Ask user for input and and retrieve values
           System.out.print("Enter the principle to borrow: $");
           principle = input.nextInt();
       
           System.out.print("Enter the interest rate in decimal: ");
           interestRate = input.nextDouble();
       
           System.out.print("Enter the term (in years): ");
           termInYears = input.nextInt();
       
           // Calculate monthly payment
           monthlyPayment = principle * interestRate / 12 * Math.pow(1 + interestRate / 12, termInYears * 12) /
               (Math.pow(1 + interestRate / 12, termInYears * 12) - 1);
       
           // Amortization table heading formatted
           System.out.printf("%10s%16s%21s%13s", "Month", "Payment", "Total Interest", "Balance");
           
           // SOLUTION USING A FOR LOOP
           for(count = 1; count <= 12 * termInYears; count++) // Initialize count to month 1 & display month 1 through end of loan term
           {
               balance = (principle * Math.pow((1 + interestRate / 12), count)) - 
                   (((Math.pow(1 + (interestRate / 12), count) - 1) * monthlyPayment) / (interestRate / 12)); // balance at end of month count
               totalInterest = ((monthlyPayment * count) - (principle - balance));
           
               if(count == 12 * termInYears) // Balance paid off at end of loan term
                   balance = 0.0;
               // Display monthly payment, total interest & balance with currency format
               System.out.printf("\n%10d%7s%10.2f%7s%10.2f%6s%11.2f", count, "$", monthlyPayment, "$", totalInterest, "$", balance);
           }
           
           // Ask if user to try again and receive user input
           System.out.print("\nWould you like to try another mortgage? Y/N: ");
           answer = input.next().charAt(0);
       } while(answer == 'y' || answer == 'Y'); // If answer is yes, do again, otherwise exit loop
       System.out.println("Goodbye!");
   }
}
