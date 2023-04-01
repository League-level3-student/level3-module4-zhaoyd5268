package _03_Hangman;

import javax.swing.JOptionPane;

public class Hangman {
	int totalwords = Utilities.getTotalWordsInFile("dictionary.txt");
	String num = JOptionPane.showInputDialog("give me a number up to " + totalwords);
	public static void main(String[] args) {

	}
}
