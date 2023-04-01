package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {
		Stack<String> hi = new Stack<String>();
		Stack<String> hello = new Stack<String>();
		boolean yesorno = true;
		for (int i = 0; i < b.length(); i++) {
			hi.add(b.charAt(i) + "");
		}
		for (int i = 0; i < hi.size(); i++) {
			if (hi.get(i).equalsIgnoreCase("{")) {
				hello.add("watermeloan");
			} else if (hi.get(i).equalsIgnoreCase("}")) {
				if (hello.isEmpty() == false) {
					hello.pop();
				} else {
					yesorno = false;
				}
			}	
		}
		if (hello.isEmpty() != true) {
			yesorno = false;
		}
		return yesorno;
	}
}