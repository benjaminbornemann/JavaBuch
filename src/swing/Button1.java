package swing;

import javax.swing.*;
import java.awt.*;

public class Button1 {

	public static void main(String[] args) {
		Button1 gui = new Button1();
		gui.los();
	}

	public void los()  {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("klick mich");
		frame.getContentPane().add(BorderLayout.EAST, button);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
	
}
