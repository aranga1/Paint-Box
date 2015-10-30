import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;



public class PaintBoxAWT extends JFrame implements MouseMotionListener{
	private Graphics graphic;
	private boolean toSquare = false;
	private int x,y;
	
	public void paint(Graphics g) {
		super.paint(g);
		if (toSquare) {
			graphic.fillRect(x, y, 20,20);
			graphic.setColor(getColor());
		}
		else {
			graphic.fillOval(x, y, 20, 20);
			graphic.setColor(getColor());
		}
	}
	
	public Color getColor() {
		int r = (int) Math.random() *256;
		int b = (int) Math.random() *256;
		int g = (int) Math.random() *256;
		
		return (new Color(r,g,b));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		if (e.isShiftDown()) {
			toSquare = true;
		}
		else {
			toSquare = false;
		}
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Paint Box!");
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new PaintBoxAWT());
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(true);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
