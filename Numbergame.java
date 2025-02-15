package dharsh_new;

	import java.util.Scanner;
	import java.util.Random;

	public class Numbergame {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	
	        // Generate a random number between 1 and 100
	        int numberToGuess = random.nextInt(100) + 1;
	        
	        int attempts = 0;
	        int guess = 0;
	        
	        System.out.println("Welcome to the Number Guessing Game!");
	        System.out.println("I am thinking of a number between 1 and 100.");
	        
	        // Game loop
	        while (guess != numberToGuess) {
	            System.out.print("Enter your guess: ");
	            
	            // Check if the input is a valid number
	            if(scanner.hasNextInt()) {
	                guess = scanner.nextInt();
	                attempts++;
	                
	                if (guess < numberToGuess) {
	                    System.out.println("Too low! Try again.");
	                } else if (guess > numberToGuess) {
	                    System.out.println("Too high! Try again.");
	                } else {
	                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
	                }
	            } else {
	                System.out.println("Please enter a valid number.");
	                scanner.next(); // clear the invalid input
	            }
	        }
	        
	        // Close the scanner
	        scanner.close();
	    }
	}



