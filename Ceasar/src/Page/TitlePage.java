package Page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TitlePage extends JFrame{
	
	private Font titleFont = new Font("한컴 백제 B",Font.BOLD,40);
	private Font desFont = new Font("한컴 백제 B",Font.PLAIN,20);
	private LineBorder border1 = new LineBorder(Color.BLACK,5,true);
	private LineBorder border2= new LineBorder(Color.BLACK,3,true);
	
	private final int WIDTH = 800;
	private final int HEIGHT = 900;
	private final int button_width = 270;
	
	private JPanel panel = new JPanel();
	private JLabel title = new JLabel("네트워크-정보보안 암호화 연습하기!");
	private JButton start = new JButton("start");
	private JButton record = new JButton("record");
	private	JButton exit = new JButton("exit");
	
	public TitlePage() {
		
		setTitle("Ceasar");
		setVisible(true);
		setSize(WIDTH,HEIGHT);
		setResizable(false);
			
		
		panel.add(title);
		title.setBounds(WIDTH/2-350, 150, 700, 80);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(titleFont);
		//atitle.setBorder(border1);
		
		
		panel.add(start);
		start.setBounds(WIDTH/2-button_width/2, 400, button_width, 65);
		start.setFont(desFont);
		start.setFocusable(false);
		start.setBorderPainted(false);
		start.setForeground(Color.WHITE);
		start.setBackground(new Color(255, 187,187));
		start.setHorizontalAlignment(JLabel.CENTER);
		start.addActionListener(new EventHandler());
		//start.setBorder(border2);
		
		
		panel.add(record);
		record.setBounds(WIDTH/2-button_width/2, 400+100, button_width, 65);
		record.setFont(desFont);
		record.setFocusable(false);
		record.setBorderPainted(false);
		record.setForeground(Color.WHITE);
		record.setBackground(new Color(255, 187,187));
		record.setHorizontalAlignment(JLabel.CENTER);
		record.addActionListener(new EventHandler());
		//record.setBorder(border2);
		
	
		panel.add(exit);
		exit.setBounds(WIDTH/2-button_width/2, 400+200, button_width, 65);
		exit.setFont(desFont);
		exit.setFocusable(false);
		exit.setBorderPainted(false);
		exit.setForeground(Color.WHITE);
		exit.setBackground(new Color(255, 187,187));
		exit.setHorizontalAlignment(JLabel.CENTER);
		exit.addActionListener(new EventHandler());
		//exit.setBorder(border2);
	
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
	}
	
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == start) {
				Multiple m = new Multiple();
				dispose();
			}else if(e.getSource() == record) {
				
			}else if(e.getSource() == exit) {
				System.exit(0);
			}
			
		}
		
	}
}
