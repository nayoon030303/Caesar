package Page;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TitlePage extends JFrame{
	public TitlePage() {
		
		setTitle("Ceasar");
		setVisible(true);
		setSize(800, 900);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setBackground(Color.WHITE);
	}
}
