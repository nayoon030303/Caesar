package Page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Page.TitlePage.EventHandler;

public class Multiple extends JFrame {

	private Font titleFont = new Font("한컴 백제 B",Font.PLAIN,30);
	private Font subFont = new Font("한컴 백제 M",Font.PLAIN,20);
	private Font lableFont = new Font("한컴 백제 B",Font.PLAIN,20);
	private Font explainFont = new Font("한컴 백제 M",Font.PLAIN,15);
	
	private LineBorder border1 = new LineBorder(Color.BLACK,2,true);
	private LineBorder border2= new LineBorder(Color.BLACK,3,true);
	
	private final int WIDTH = 800;
	private final int HEIGHT = 630;
	
	private final int title_Width = 500;
	private final int input_Width = 650;
	
	private JPanel panel = new JPanel();
	private JButton btn = new JButton("암호화/복호화 하러가기");
	private JTextField key = new JTextField();
	private JTextField str = new JTextField();
	private JLabel key_explain = new JLabel("*한국어,숫자,특수문자 입력은 허용되지 않습니다.");
	private JLabel str_explain = new JLabel("*한국어,숫자,특수문자 입력은 허용되지 않습니다.");
	
	public Multiple() {
		setTitle("Ceasar");
		setVisible(true);
		setSize(WIDTH,HEIGHT);
		
	
		JLabel title = new JLabel("다중 문자 치환 암호화 공부하기 !");
		panel.add(title);
		title.setBounds(WIDTH/2-title_Width/2, 20, title_Width, 100);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(titleFont);
		//title.setBorder(border1);
		
		JLabel subTitle = new JLabel("암호화와 복호화를 직접 연습해보아요");
		panel.add(subTitle);
		subTitle.setBounds(WIDTH/2-title_Width/2, 90, title_Width, 50);
		subTitle.setHorizontalAlignment(JLabel.CENTER);
		subTitle.setFont(subFont);
		//subTitle.setBorder(border1);
		
		JLabel keyLabel = new JLabel("암호화에 쓰일 키를 입력해주세요");
		panel.add(keyLabel);
		keyLabel.setBounds(WIDTH/2-input_Width/2+5, 180, title_Width, 50);
		keyLabel.setHorizontalAlignment(JLabel.LEFT);
		keyLabel.setFont(lableFont);
		
		
		
		panel.add(key);
		key.setBounds(WIDTH/2-input_Width/2, 235, input_Width, 50);
		key.setHorizontalAlignment(JLabel.LEFT);
		key.setFont(subFont);
		
		
		
		panel.add(key_explain);
		key_explain.setBounds(WIDTH/2-input_Width/2+5, 275, title_Width, 50);
		key_explain.setForeground(Color.GRAY);
		key_explain.setHorizontalAlignment(JLabel.LEFT);
		key_explain.setFont(explainFont);
		
		
		JLabel strLabel = new JLabel("암호화할 문자열을 입력해주세요");
		panel.add(strLabel);
		strLabel.setBounds(WIDTH/2-input_Width/2+5, 330, title_Width, 50);
		strLabel.setHorizontalAlignment(JLabel.LEFT);
		strLabel.setFont(lableFont);
		
		
		panel.add(str);
		str.setBounds(WIDTH/2-input_Width/2, 385, input_Width, 50);
		str.setHorizontalAlignment(JLabel.LEFT);
		str.setFont(subFont);
		
		
		panel.add(str_explain);
		str_explain.setBounds(WIDTH/2-input_Width/2+5, 425, title_Width, 50);
		str_explain.setForeground(Color.GRAY);
		str_explain.setHorizontalAlignment(JLabel.LEFT);
		str_explain.setFont(explainFont);
		
		
		panel.add(btn);
		btn.setBounds(WIDTH/2-150, 500, 300, 50);
		btn.setFocusable(false);
		btn.setBorderPainted(false);
		btn.setForeground(Color.WHITE);
		btn.setBackground(new Color(255, 187,187));
		btn.setHorizontalAlignment(JLabel.CENTER);
		btn.setFont(lableFont);
		btn.addActionListener(new EventHandler());
		
		
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		
	}
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn) {
		
				String _key = key.getText();
				String _str = str.getText();
				boolean start = true;
				
				//예외 처리
				if(_key.length()<=0) {
					key_explain.setForeground(Color.RED);
					start = false;
				}
				if(_str.length()<=0) {
					str_explain.setForeground(Color.RED);
					start = false;
				}
				for(int i=0; i<_key.length(); i++) {
					if(!(_key.charAt(i) >= 'A' && _key.charAt(i)<='Z' ||
							_key.charAt(i) >= 'a' && _key.charAt(i)<='z'))
					{
						key_explain.setForeground(Color.RED);
						start = false;
						break;
					}
				}
				for(int i=0; i<_str.length(); i++) {
					if(!(_str.charAt(i) >= 'A' && _str.charAt(i)<='Z' ||
							_str.charAt(i) >= 'a' && _str.charAt(i)<='z'))
					{
						str_explain.setForeground(Color.RED);
						start = false;
						break;
					}
				}
				
				if(start) {
					
					ResultPage r = new ResultPage(_key,_str);
					dispose();
				}
			}
			
		}
		
	}
}
