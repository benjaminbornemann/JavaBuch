package Pack1;

import javax.swing.*;
import java.awt.event.*;

public class EinfacheGui1 implements ActionListener  {

	JButton button;
	
	public static void main(String[] args) {
				
		EinfacheGui1 gui = new EinfacheGui1();
		gui.los();
	}

	public void los()  {
		JFrame frame = new JFrame();
		button = new JButton("klick mich");
		
		button.addActionListener(this);
		
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
		}
	
	public void actionPerformed(ActionEvent event  ) {
		button.setText("Ich wurde geklickt:");
	}
}
