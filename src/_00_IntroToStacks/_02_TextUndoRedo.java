package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	Stack<String> s = new Stack<String>();
	String addthis = "";

	public static void main(String[] args) {
		_02_TextUndoRedo hi = new _02_TextUndoRedo();
		hi.frame.add(hi.panel);
		hi.panel.add(hi.label);
		hi.frame.addKeyListener(hi);
		hi.frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int keycode = k.getKeyCode();
		Character newone = k.getKeyChar();
		if (keycode != 8 && keycode != 16) {			
			System.out.println(keycode);
			addthis += newone;
			label.setText(addthis);
		} else if (keycode == 8) {
			s.push(label.getText().charAt(label.getText().length()-1)+"");
			addthis = label.getText().substring(0, label.getText().length()-1);
			label.setText(addthis);	
		} else if (keycode == 16) {
			String addback = s.pop();
			addthis+=addback;
			label.setText(addthis);
		}
		System.out.println(s);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
