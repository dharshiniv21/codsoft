package dharsh_new;

import java.util.Scanner;

public class ATMInterface {
    
    private static double balance = 1000.00; // Initial balance in the account
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pin = 1221; // Set ATM pin
        int enteredPin;
        
        // Prompt the user to enter the ATM pin
        System.out.print("Enter your ATM PIN: ");
        enteredPin = scanner.nextInt();
        
        // Check if the entered pin is correct
        if (enteredPin == pin) {
            System.out.println("PIN correct. Welcome to the ATM.");
            
            // Menu loop for ATM options
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Please choose an option (1-4): ");
                
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        depositMoney(scanner);
                        break;
                    case 3:
                        withdrawMoney(scanner);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            }
        } else {
            System.out.println("Incorrect PIN. Access Denied.");
        }
        
        scanner.close();
    }
    
    // Method to check balance
    public static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }
    
    // Method to deposit money
    public static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double depositAmount = scanner.nextDouble();
        
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("You have successfully deposited: $" + depositAmount);
            System.out.println("Your new balance is: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }
    
    // Method to withdraw money
    public static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double withdrawAmount = scanner.nextDouble();
        
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("You have successfully withdrawn: $" + withdrawAmount);
            System.out.println("Your new balance is: $" + balance);
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient balance for the requested withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        }
    }
}
