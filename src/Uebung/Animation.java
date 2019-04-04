package Uebung;

import javax.swing.*;
import java.awt.*;

public class Animation {

	int x = 1;
	int y = 1;
	
	public static void main(String[] args) {
		Animation gui = new Animation();
		gui.los();
	}
	public void los()  {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MeinZP zP = new MeinZP();
		
		frame.getContentPane().add(zP);
		frame.setSize(550,300);
		frame.setVisible(true);
		
		for (int i = 0; i < 124; i++, y++, x++)  {
			x++;
			zP.repaint();
			try  {
				Thread.sleep(50);
			}  catch  (Exception ex)  {
				}
			
		}
	}
	
	class MeinZP extends JPanel  {
		public void paintComponent(Graphics g)  {
			g.setColor(Color.white);
			g.fillRect(0,  0,  500,  250);
			g.setColor(Color.blue);
			g.fillRect(x,  y,  500-x*2, 250-y*2);
		}
	}
	
}
