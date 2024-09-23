/*
 * Class: CMSC203 
 * Instructor: Dr. Kuijt
 * Description: A project that simulates a random color guessing game
 * Due: 09/22/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: RAUNAK MAHESHWARI
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
public class ESPGame {
	public static void main(String[] args) throws FileNotFoundException{
		Boolean isColor;
		final int ROUNDS = 3;
		String guessedColor, correctColor = "", name, description, dueDate;
		int correctGuesses = 0;
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		
		int lineNum;
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		System.out.print("Enter the filename: ");
		String fileName = scanner.nextLine();
		Scanner fileScanner = new Scanner(new File(fileName));
		while (fileScanner.hasNextLine()) {
			System.out.println(fileScanner.nextLine());
					
			
		}
		
		for (int i = 0; i < ROUNDS; i++) {
			isColor = false;
			Scanner fileReaderScanner = new Scanner(new File(fileName));
			lineNum = 0;
			int num = rand.nextInt(1, 17);
			System.out.println("Round " + (i + 1));
			System.out.println(" ");
			System.out.println("I am thinking of a color.");
			System.out.println("Is it one of the colors above?");
			System.out.println("Enter your guess: ");
			guessedColor = scanner.nextLine().toLowerCase();
			Scanner validatedScanner = new Scanner(new File(fileName));
			while(validatedScanner.hasNextLine()) {
				String validatedLine = validatedScanner.nextLine();
				int validatedSpaceIndex = validatedLine.indexOf(" ");
				String validatedColor = validatedLine.substring(validatedSpaceIndex + 1);
				validatedColor = validatedColor.substring(0, 1).toUpperCase() + validatedColor.substring(1, validatedColor.length());
				if (validatedColor.toLowerCase().equals(guessedColor)) {
					isColor = true;
					break;
				}
			}
			
			while (isColor == false) {
				System.out.println("Enter your guess: ");
				guessedColor = scanner.nextLine().toLowerCase();
				Scanner secondValidatedScanner = new Scanner(new File(fileName));
				while(secondValidatedScanner.hasNextLine()) {
					String validatedLine = secondValidatedScanner.nextLine();
					int validatedSpaceIndex = validatedLine.indexOf(" ");
					String validatedColor = validatedLine.substring(validatedSpaceIndex + 1);
					validatedColor = validatedColor.substring(0, 1).toUpperCase() + validatedColor.substring(1, validatedColor.length());
					if (validatedColor.toLowerCase().equals(guessedColor)) {
						isColor = true;
						break;
						
						
					}
				}
			}
			while (fileReaderScanner.hasNextLine()) {
				
				String line = fileReaderScanner.nextLine();
				if (num == lineNum) {
					int spaceIndex = line.indexOf(" ");
					correctColor = line.substring(spaceIndex + 1);
					correctColor = correctColor.substring(0, 1).toUpperCase() + correctColor.substring(1, correctColor.length());
					System.out.println("I was thinking of " + correctColor + ".");
				}
				lineNum += 1;
				
			}
			if (correctColor == guessedColor) {
				correctGuesses += 1;
			}
			
			fileReaderScanner.close();
			
		}
		
		System.out.println("Game Over");
		System.out.println("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.");
		System.out.print("Enter your name: ");
		Scanner outputScanner = new Scanner(System.in);
		name = outputScanner.nextLine();
		System.out.print("Describe yourself: ");
		description = outputScanner.nextLine();
		System.out.print("Due Date: ");
		dueDate = outputScanner.nextLine();
		System.out.println("User Name: " + name);
		System.out.println("User Description: " + description);
		System.out.println("Due Date: " + dueDate);

		fileScanner.close();
		outputScanner.close();
	}
}
