package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Textbereich1 implements ActionListener {

	JTextArea text;
	
	public static void main(String[] args) {
		Textbereich1 gui = new Textbereich1();
		gui.los();
		}

	public void los()  {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JButton button = new JButton("einfach anklicken");
		button.addActionListener(this);
		text = new JTextArea(10, 20);
		text.setLineWrap(true);
		
		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
		frame.setSize(350, 300);
		frame.setVisible(true);
		}
	
	public void actionPerformed(ActionEvent ev)  {
		text.append("Button angeklickt \n");
	}
	
}
