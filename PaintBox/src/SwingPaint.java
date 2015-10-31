import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class SwingPaint {
	JButton clear, makeBig, makeSmall, erase, save;
	PaintBoxAWT draw;
	ActionListener aL = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == clear) {
				draw.clear();
			}
			else if (e.getSource() == makeBig) {
				draw.big = true;
				draw.normal();
			}
			else if (e.getSource() == makeSmall) {
				draw.big = false;
				draw.normal();
			}
			else if (e.getSource() == erase) {
				draw.erase();
			}
			else if (e.getSource() == save) {
				draw.save();
			}
		}
	};
	
	public static void main(String[] args) {
		new SwingPaint().create();
	}
	
	public void create() {
		JFrame frame = new JFrame("Paint Box!");
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		draw = new PaintBoxAWT();
		content.add(draw, BorderLayout.CENTER);
		JPanel controls = new JPanel();
		clear = new JButton("Clear this stuff!");
		makeBig = new JButton("Make this stuff huge!");
		makeBig.addActionListener(aL);
		makeSmall = new JButton("Go back to normal");
		save = new JButton("Save!");
		erase = new JButton("Erase this!");
		erase.addActionListener(aL);
		save.addActionListener(aL);
		makeSmall.addActionListener(aL);
		clear.addActionListener(aL);
		controls.add(clear);
		controls.add(makeBig);
		controls.add(makeSmall);
		controls.add(erase);
		controls.add(save);
		content.add(controls, BorderLayout.NORTH);
		frame.setSize(800, 700);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
