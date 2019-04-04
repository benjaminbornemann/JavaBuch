package swing;

import javax.swing.*;
import java.awt.*;

public class Panel1 {

	public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.los();
	}

	public void los()  {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton button1 = new JButton("hau drauf");
		JTextField feld = new JTextField(20);
		feld.setText("Huhu");
		
		
		panel.add(button1);
		panel.add(feld);
		
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
}
