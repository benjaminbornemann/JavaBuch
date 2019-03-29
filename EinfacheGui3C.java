package Pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EinfacheGui3C implements ActionListener  {

	JFrame frame;
	
	public static void main(String[] args) {
		EinfacheGui3C gui = new EinfacheGui3C();
		gui.los();
	}

	public void los()  {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Farbe wechseln");
		button.addActionListener(this);
		
		MeinZeichenPanel zeichenPanel= new MeinZeichenPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, zeichenPanel);
		frame.setSize(300,  300);
		frame.setVisible(true);
	}	
	
	public void actionPerformed(ActionEvent event)  {
		frame.repaint();
	}
  }
