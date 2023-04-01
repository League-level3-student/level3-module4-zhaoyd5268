package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> hi = new Stack<Double>();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random ran = new Random();
		for (int i = 0; i < 101; i++) {
			double useThis = ran.nextDouble() * 100;
			hi.push(useThis);
		}
		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		String number1 = JOptionPane.showInputDialog("Enter one number between 0-100 inclusive");
		String number2 = JOptionPane.showInputDialog("Enter another number between 0-100 inclusive");
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.
		System.out.println("These numbers are in between the two you entered");
		for (int i = hi.size()-1; i > 0; i--) {
			if (num1 < num2) {
				if (hi.get(i) > num1 && hi.get(i) < num2) {
					String printThis = "" + hi.get(i);
					System.out.println(printThis);
					
				}
			} else if (num2 < num1) {
				if (hi.get(i) < num1 && hi.get(i) > num2) {
					String printThis = "" + hi.get(i);
					System.out.println(printThis);
				}
			}

 

		}

		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}
