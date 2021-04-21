package Page;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ResultPage extends JFrame {

	private Font titleFont = new Font("한컴 백제 B",Font.PLAIN,30);
	private Font subFont = new Font("한컴 백제 M",Font.PLAIN,20);
	private Font lableFont = new Font("한컴 백제 B",Font.PLAIN,20);
	
	private LineBorder border1 = new LineBorder(Color.BLACK,2,true);
	
	private final int WIDTH = 800;
	private final int HEIGHT = 1000;
	private final int board_Width = 60;
	
	private final int title_Width = 500;
	private final int input_Width = 650;
	
	public ResultPage(String _key, String _str) {
		setTitle("Ceasar");
		setVisible(true);
		setSize(WIDTH,HEIGHT);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
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
		
		JLabel keyLabel = new JLabel("암호화에 쓴 키");
		panel.add(keyLabel);
		keyLabel.setBounds(WIDTH/2-input_Width/2+5, 180, title_Width, 50);
		keyLabel.setHorizontalAlignment(JLabel.LEFT);
		keyLabel.setFont(lableFont);
		
		JLabel key = new JLabel(" "+_key);
		panel.add(key);
		key.setBounds(WIDTH/2-input_Width/2+5, 235, input_Width, 50);
		key.setHorizontalAlignment(JLabel.LEFT);
		key.setFont(subFont);
		key.setBorder(border1);
		
		JLabel strLabel = new JLabel("암호화 할 문자열");
		panel.add(strLabel);
		strLabel.setBounds(WIDTH/2-input_Width/2+5, 300, title_Width, 50);
		strLabel.setHorizontalAlignment(JLabel.LEFT);
		strLabel.setFont(lableFont);
		
		JLabel str = new JLabel(" "+_str);
		panel.add(str);
		str.setBounds(WIDTH/2-input_Width/2+5, 350, input_Width, 50);
		str.setHorizontalAlignment(JLabel.LEFT);
		str.setFont(subFont);
		str.setBorder(border1);
		
		JLabel boardLabel = new JLabel("암호판");
		panel.add(boardLabel);
		boardLabel.setBounds(WIDTH/2-input_Width/2+5, 450, title_Width, 50);
		boardLabel.setHorizontalAlignment(JLabel.LEFT);
		boardLabel.setFont(lableFont);
		
		JLabel[] board = new JLabel[25];
		for(int i=0; i<board.length; i++) {
			int x= i%5; 
			int y = i/5;
			board[i] =  new JLabel(i+"",JLabel.CENTER);
			panel.add(board[i]);
			board[i].setBounds(WIDTH/2-input_Width/2+5+x*board_Width,505+y*board_Width,board_Width,board_Width);
			board[i].setBorder(border1);
		}
		
		JLabel divStr = new JLabel("asdf");
		panel.add(divStr);
		divStr.setBounds(WIDTH/2-input_Width/2+5, 850, input_Width, 50);
		divStr.setHorizontalAlignment(JLabel.LEFT);
		divStr.setFont(lableFont);
	}
}
