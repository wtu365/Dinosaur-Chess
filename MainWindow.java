package game;
import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3806958050893938040L;
	private JFrame frame;
	private Image background;
	private JPanel panel;
	private JLabel label;
	
	public MainWindow() {
		this.frame = new JFrame(); 
		this.frame.setTitle("Machine Gun Pacman");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setSize(800, 800);
		this.frame.setLocationRelativeTo(null);
		
		//this.background = new ImageIcon("Background.jpg").getImage();
		this.panel = new JPanel();
		this.label = new JLabel("Hello World");
		this.panel.add(this.label);
		this.frame.add(panel);
		
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
		
		g2d.drawImage(this.background, 0, 0, null);
	}
}
