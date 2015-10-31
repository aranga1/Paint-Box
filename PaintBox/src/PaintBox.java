import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;


public class PaintBox extends Applet implements MouseMotionListener {
	private Graphics graphic;
	public void init() {
		this.addMouseMotionListener(this);
	}
	public void paint(Graphics g) {
		graphic = g.create();
		this.setSize(new Dimension(1000,700));
	}
	
	public void drawCircle(int x, int y, int width) {
		graphic.setColor(getColor());
		Ellipse2D circle = new Ellipse2D.Double((double)x,(double)y,(double)width,(double)width);
		Graphics2D gg = (Graphics2D) graphic;
		gg.fill(circle);
	}
	public void drawSquare(int x, int y, int width) {
		graphic.setColor(getColor());
		graphic.fillRect(x, y, width, width);
	}
	
	public Color getColor() {
		int r = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		Color c = new Color(r,g,b);
		return c;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.isShiftDown()) {
			int x = e.getX();
			int y = e.getY();
			drawSquare(x,y,20);
		}
		else {
			int x = e.getX();
			int y = e.getY();
			drawCircle(x,y,20);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
