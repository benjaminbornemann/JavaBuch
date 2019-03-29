package Pack1;

import javax.swing.*;
import java.awt.*;



public class MeinZeichenPanel extends JPanel  {
	public void paintComponent(Graphics g)  {
		Graphics2D g2d = (Graphics2D) g;
		
		int rot = (int) (Math.random() * 255);
		int gruen = (int) (Math.random() * 255);
		int blau = (int) (Math.random() * 255);
		Color startColor = new Color(rot, gruen, blau);
		
		rot = (int) (Math.random() * 255);
		gruen = (int) (Math.random() * 255);
		blau = (int) (Math.random() * 255);
		Color endColor = new Color(rot, gruen, blau);
				
		
		GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(70,  70,  100,  100);
	}
}
