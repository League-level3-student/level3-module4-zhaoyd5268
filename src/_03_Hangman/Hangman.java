package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman implements KeyListener {
	int totalwords = Utilities.getTotalWordsInFile("dictionary.txt");
	String num = JOptionPane.showInputDialog("give me a number up to " + totalwords);
	int othernum = Integer.parseInt(num);
	static Stack<String> s = new Stack<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField wordletters = new JTextField(1);
	JLabel displayedword = new JLabel();
	int wordlength = 0;
	JLabel howmanywords = new JLabel();
	int lives = 10;
	JLabel showlives = new JLabel();
	String word = "";
	ArrayList<Character> listofletters = new ArrayList<Character>();
	Boolean hi = false;
	String underscore = "_";

	public void setup() {
		push();
		stuff();
	}

	public void push() {
		for (int i = 0; i < othernum; i++) {
			s.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
	}

	public void stuff() {
		System.out.println(s);
		if (s.size() != 0) {
			word = s.pop();
		} else {
			JOptionPane.showMessageDialog(null, "You finished all your words! I'll set up another round for you!"
					+ "You can close this window after the new one is created!");
			Hangman h = new Hangman();
			h.setup();
		}
		wordlength = word.length();
		panel.add(wordletters);
		panel.add(howmanywords);
		panel.add(displayedword);
		panel.add(showlives);
		showlives.setText("Lives: " + lives);
		howmanywords.setText("This word has " + wordlength + " letters");
		for (int i = 0; i < wordlength; i++) {
			displayedword.setText(displayedword.getText() + underscore);
		}
		displayedword.setSize(300, 300);
		wordletters.setSize(1, 1);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		wordletters.addKeyListener(this);

	}

	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.setup();

	}

	@Override
	public void keyTyped(KeyEvent e) {

		if (lives != 0) {
			hi = false;
			Character a = e.getKeyChar();
			for (int i = 0; i < wordlength; i++) {
				if (a == word.charAt(i)) {
					StringBuilder hello = new StringBuilder(displayedword.getText());
					hello.replace(i, i + 1, a + "");
					hello.toString();
					displayedword.setText(hello + "");
					hi = true;
					frame.pack();
				}
			}
			if (hi == false && e.getKeyCode() != 8) {
				lives -= 1;
				System.out.println("you're wrong L Bozo. You have " + lives + " lives left.");
			} else if (lives == 0) {

				System.out.println("YOURE OUT OF LIVES!");
			}
			showlives.setText("Lives: " + lives);
		}
		frame.pack();
		if (displayedword.getText().equalsIgnoreCase(word)) {
			JOptionPane.showMessageDialog(null, "Next word! Congratulations!");
			displayedword.setText("");
			howmanywords.setText("");
			stuff();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
