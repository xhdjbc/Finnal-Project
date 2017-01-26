
/**
 *
 * Name: Zichao Liu
 * Teacher: Mr.Hardman
 * Final Project
 * Date Last Modified: 1/26/2017
 *
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author z.liu
 *
 */
public class ScientificCalculator {

	private static Scanner userInput;

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		int userChoice;
		int factorialCalculation;
		int[] Array = new int[5];
		double Number;
		double Root;
		double Base;
		double Exponent;

		System.out.println("Hi, user! Which functions you need?");
		int choice = getuserChoice();

		// Factorial
		if (choice == 1) {
			System.out.print("Please enter a number that you want the factorial of: ");
			userChoice = userInput.nextInt();

			factorialCalculation = calculateFactorial(userChoice);

			System.out.println("The value of " + userChoice + "! is: " + factorialCalculation);
		} else if (choice == 2) {
			// permutation
			for (int i = 0; i < Array.length; i++) {

				System.out.println("Enter a number as an integer: ");
				Array[i] = userInput.nextInt();
			}
			System.out.println("This array's permutation is:");
			permute(Array, 0);
		} else if (choice == 3) {
			// combination
			System.out.println("This array's combination is:");
			Arrays.sort(Array);
			combine(Array);
		} else if (choice == 4) {
			// Logarithm (Base 10 and e)
			int userChoiceInLogarithm;

			System.out.println("Please enter a number as an integer:");
			Number = userInput.nextDouble();

			System.out.println("Which base you need?");
			userChoiceInLogarithm = getuserChoiceInLogarithm();
			if (Number >= 0) {

				if (userChoiceInLogarithm == 1) {
					System.out.println("The logarithm value of " + Number + " on base 10 is: " + Math.log10(Number));
				} else if (userChoiceInLogarithm == 2) {
					System.out.println("The logarithm value of " + Number + " on base e is : " + Math.log(Number));
				}
			}
			while (Number < 0) {
				System.out.println("You can't take this number.");
				System.out.println("Please think of a number again:");
				Number = userInput.nextInt();

				if (Number >= 0) {
					if (userChoiceInLogarithm == 1) {
						System.out
								.println("The logarithm value of " + Number + " on base 10 is: " + Math.log10(Number));
					} else if (userChoiceInLogarithm == 2) {
						System.out.println("The logarithm value of " + Number + " on base e is : " + Math.log(Number));
					}
				}
			}

		}

		// Root
		else if (choice == 5) {

			System.out.println("Please think of a number as an integer:");
			Number = userInput.nextDouble();

			System.out.println("Please think of a root:");
			Root = userInput.nextDouble();

			if (Number >= 0) {
				System.out.println(Math.pow(10, Math.log10(Number) / Root));
			}
			while (Number <= 0) {
				System.out.println("You can't take the root of this number.");
				System.out.println("Please think of a number again:");
				Number = userInput.nextInt();

				if (Number >= 0) {
					System.out.println(Math.pow(10, Math.log10(Number) / Root));
				}
			}
		}

		else if (choice == 6) {
			// Power

			System.out.println("Please enter a number for base:");
			Base = userInput.nextDouble();

			System.out.println("Please enter a number for exponent:");
			Exponent = userInput.nextDouble();
			double Result = Power(Base, Exponent);
			System.out.println(Base + " to the power of " + Exponent + " is " + Result + ".");
		}

		else if (choice == 7) {
			// Trigonometric Function
			double Degrees;

			System.out.println("Please enter a angle:");
			Degrees = userInput.nextDouble();

			double Radians = Math.toRadians(Degrees);
			System.out.format("The sine of %.1f degrees is %.4f%n", Degrees, Math.sin(Radians));
			System.out.format("The cos of %.1f degrees is %.4f%n", Degrees, Math.cos(Radians));
			System.out.format("The tan of %.1f degrees is %.4f%n", Degrees, Math.tan(Radians));
			System.out.format("The arcsine of %.1f degrees is %.4f%n", Degrees, Math.asin(Radians));
			System.out.format("The arccos of %.1f degrees is %.4f%n", Degrees, Math.acos(Radians));
			System.out.format("The arctan of %.1f degrees is %.4f%n", Degrees, Math.atan(Radians));
		}

		else if (choice == 8) {
			// Pi
			System.out.format("The value of pi is %.10f%n", Math.PI);
		}

		userInput.close();
	}

	/**
	 * to show the user how many functions can be selected
	 * 
	 * @return is to let the user select a function and return to the Main
	 *         method
	 */
	static int getuserChoice() {
		userInput = new Scanner(System.in);
		System.out.println("1. Factorial");
		System.out.println("2. Permutation");
		System.out.println("3. Combination");
		System.out.println("4. Logarithm");
		System.out.println("5. Root");
		System.out.println("6. Power");
		System.out.println("7. Trigonometric Function");
		System.out.println("8. Pi");
		return userInput.nextInt();

	}

	/**
	 * calculateFactorial calculate the factorial of any number passed to the
	 * method
	 * 
	 * @param numberToFactorial
	 *            is the number calculate the factorial of
	 * 
	 * @return the calculated factorial for the given number
	 */
	public static int calculateFactorial(int numberToFactorial) {

		int calculation = 1;

		for (int i = numberToFactorial; i > 0; i--) {
			calculation = calculation * i;
		}

		return calculation;

	}

	/**
	 * Gets the full permutation of arrays
	 * 
	 * @param Array
	 *            is an array to permute what is user entered
	 * @param index
	 *            is represents the position of this element in the array
	 */
	private static void permute(int[] Array, int index) {
		if (index >= Array.length - 1) {
			System.out.print("[");
			for (int i = 0; i < Array.length - 1; i++) {
				System.out.print(Array[i] + ", ");
			}
			if (Array.length > 0)
				System.out.print(Array[Array.length - 1]);
			System.out.println("]");
			return;
		}

		for (int i = index; i < Array.length; i++) {
			int t = Array[index];
			Array[index] = Array[i];
			Array[i] = t;

			permute(Array, index + 1);

			t = Array[index];
			Array[index] = Array[i];
			Array[i] = t;
		}
	}

	/**
	 * Gets the full combination of arrays
	 * 
	 * @param Array
	 *            is an array to permute what is user entered
	 * @param Range
	 *            is a range for how many numbers of each set
	 */
	private static void combine(int[] Array, int... Range) {
		if (Range.length == 0) {
			for (int i = 1; i <= Array.length; i++) {
				int[] Result = new int[i];
				doCombine(Array, Result, 0, 0, i);
			}
		} else {
			int[] Result = new int[Range[0]];
			doCombine(Array, Result, 0, 0, Range[0]);
		}
	}

	/**
	 * Gets the full combination of arrays
	 * 
	 * @param Array
	 *            is an array to permute what is user entered
	 * @param Result
	 *            is the resulting array of combinations
	 * @param currIndex
	 *            is represents the position of this element in the Result
	 * @param Level
	 *            is represents the position of this element in the Array
	 * @param Range
	 *            is a range for how many numbers of each set in the Result
	 */
	private static void doCombine(int[] Array, int[] Result, int currIndex, int Level, int Range) {
		if (Level == Range) {
			printArray(Result);
			return;
		}
		for (int i = currIndex; i < Array.length; i++) {
			Result[Level] = Array[i];
			doCombine(Array, Result, i + 1, Level + 1, Range);
			if (i < Array.length - 1 && Array[i] == Array[i + 1]) {
				i++;
			}
		}
	}

	/**
	 * Print array elements, separated by spaces
	 * 
	 * @param Result
	 *            is the number of groups to print
	 */
	private static void printArray(int[] Result) {
		for (int i = 0; i < Result.length; i++) {
			System.out.print(Result[i] + " ");
		}
		System.out.println();
	}

	static int getuserChoiceInLogarithm() {
		userInput = new Scanner(System.in);
		System.out.println("1. Base on 10");
		System.out.println("2. Base on e");
		return userInput.nextInt();
	}

	/**
	 * Calculate how to find the power to the Exponent of the Base
	 * 
	 * @param Base
	 *            is the base what is user entered
	 * @param Exponent
	 *            is the exponent what is user entered
	 * @return Power
	 */
	public static double Power(double Base, double Exponent) {
		double Result = 1;

		if (Exponent < 0) {
			Base = 1.0 / Base;
			Exponent = -Exponent;
		}

		for (int i = 0; i < Exponent; i++) {
			Result = Result * Base;
		}

		return Result;
	}

}
