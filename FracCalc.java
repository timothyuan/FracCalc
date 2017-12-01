package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equationF
		String s = "";
		//System.out.println(produceAnswer("-3/7 - 20"));
		Scanner scan = new Scanner(System.in);
		s = scan.nextLine();
		while (!s.equals("quit")) {
			System.out.println(produceAnswer(s));
			s = scan.nextLine();
		}
		scan.close();
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		Scanner sc = new Scanner(input);
		sc.useDelimiter("\\s\\+\\s|\\s\\-\\s|\\s\\*\\s|\\s\\/\\s");
		String first = sc.next();
		int whole1 = whole(first);
		int num1 = numerator(first);
		int den1 = denominator(first);
		String second = sc.next();
		int whole2 = whole(second);
		int num2 = numerator(second);
		int den2 = denominator(second);
		sc.close();
		return "whole:" + whole2 + " numerator:" + num2 + " denominator:" + den2;
	}

	public static int whole(String s) {
		int before = 0;
		int start = 0;
		int end = s.length();
		if (s.contains("_")) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '_') {
					end = i;
					for (int j = i - 1; j >= 0; j--) {
						if (!Character.isDigit(s.charAt(j))) {
							start = j + 1;
						}
					}
				}
			}
			before = Integer.parseInt(s.substring(start, end));
		}else if(!(s.contains("/")||s.contains("_"))) {
			before = Integer.parseInt(s.substring(start,end));
		}
		return before;
	}

	public static int numerator(String s) {
		int before = 0;
		int start = 0;
		int end = 0;
		if (s.contains("/")) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '/') {
					end = i;
					for (int j = i - 1; j >= 0; j--) {
						if (!Character.isDigit(s.charAt(j))) {
							start = j + 1;
						}
					}
				}
			}
			before = Integer.parseInt(s.substring(start, end));
		}
		return before;
	}
	public static int denominator(String s) {
		int after = 1;
		int end = s.length();
		if (s.contains("/")) {
			for (int i = 0; i < end; i++) {
				if (s.charAt(i) == '/') {
					after = Integer.parseInt(s.substring(i + 1, end));// prints string from / to end
				}
			}
		}
		return after;
	}

}
