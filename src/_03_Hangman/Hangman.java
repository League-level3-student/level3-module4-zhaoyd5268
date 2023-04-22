package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Hangman implements KeyListener {
	int totalwords = Utilities.getTotalWordsInFile("dictionary.txt");
	String num = JOptionPane.showInputDialog("give me a number up to " + totalwords);
	int othernum = Integer.parseInt(num);
	static Stack<String> s = new Stack<String>();
	JFrame frame = new JFrame();
	JTextField wordletters = new JTextField();
	JLabel wordsize = new JLabel();
	JLabel displayedword = new JLabel();
	int wordlength = 0;
	int lives = 0;
	int x = 0;
	String word = ""; 
	Boolean hi = false;

	public void stuff() {
		lives = 10;
		for (int i = 0; i < othernum; i++) {
			s.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		System.out.println(s);
		word = s.pop();
		wordlength = word.length();
		for (int i = 0; i < wordlength; i++) {
		}
		frame.add(wordletters);
		frame.add(wordsize);
		wordletters.setText("");
		wordletters.setSize(50, 50);
		wordsize.setSize(200, 200);
		wordsize.setText(wordlength + " characters long total");
		frame.setVisible(true);
		wordletters.addKeyListener(this);

	}

	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.stuff();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (lives != 0) {
			for (int i = 0; i < wordlength; i++) {
				int x = i;
				hi = false;
				Character keyevent = word.charAt(x);
				x += 1;
				Character a = e.getKeyChar();
				if (a.compareTo(keyevent) == 0) {
					displayedword.setText(displayedword + a.toString());
					hi = true;
				}
				
			}
			if (hi == false) {
				lives -= 1;
				System.out.println("testboy");
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
