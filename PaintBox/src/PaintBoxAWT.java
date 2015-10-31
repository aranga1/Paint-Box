import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class PaintBoxAWT extends JComponent {
	private Image image;
	public boolean big = false;
	public boolean eraseMode = false;
	private Graphics2D g;
	private int currentX, currentY, oldX, oldY;
	
	public PaintBoxAWT() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				
				if (g != null) {
					if (big) {
						g.setStroke(new BasicStroke(5));
						g.drawLine(oldX, oldY, currentX, currentY);
						repaint();
						oldX = currentX;
						oldY = currentY;
					}
					else {
						g.setStroke(new BasicStroke());
						g.drawLine(oldX, oldY, currentX, currentY);
						repaint();
						
						oldX = currentX;
						oldY = currentY;
					}
				}
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		if (image == null) {
			image = createImage(getSize().width, getSize().height);
			this.g = (Graphics2D) image.getGraphics();
			this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}
		
		g.drawImage(image, 0, 0, null);
	}
	
	public void clear() {
		g.setPaint(Color.WHITE);
		g.fillRect(0, 0, getSize().width, getSize().height);
		g.setPaint(Color.BLACK);
		repaint();
	}
	public void normal() {
		g.setPaint(Color.BLACK);
	}
	public void erase() {
		g.setPaint(Color.white);
	}
	public void save() {
		String filename = JOptionPane.showInputDialog("What do you want the file to be named?");
		BufferedImage b = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);
		Graphics bGraphics = b.getGraphics();
		bGraphics.drawImage(image, 0, 0, null);
		try {
			ImageIO.write(b, "PNG", new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
