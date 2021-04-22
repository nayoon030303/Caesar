package Page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class ResultPage extends JFrame {

	private Font titleFont = new Font("한컴 백제 B",Font.PLAIN,30);
	private Font subFont = new Font("한컴 백제 M",Font.PLAIN,23);
	private Font lableFont = new Font("한컴 백제 B",Font.PLAIN,25);
	
	private final int WIDTH = 800;
	private final int HEIGHT = 1000;
	private final int board_Width = 60;
	
	private final int title_Width = 500;
	private final int input_Width = 650;
	
	private LineBorder border1 = new LineBorder(Color.BLACK,2,true);
	private JLabel[] board = new JLabel[25];
	private JLabel divStr = new JLabel("asdf");
	private JLabel changeStr = new JLabel("asdf");
	private JPanel panel = new JPanel();
	private Dimension size = new Dimension();
	private JScrollPane scroll;
	
	private String zCheck ="";
	private String blankCheck="";
	private int blankCheckCount=0;
	
	public ResultPage(String _key, String _str) {
		
		_key = _key.toUpperCase();
		_str = _str.toUpperCase();
	
		
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
		
		
		for(int i=0; i<board.length; i++) {
			int x= i%5; 
			int y = i/5;
			board[i] =  new JLabel();
			board[i].setHorizontalAlignment(JLabel.CENTER);
			panel.add(board[i]);
			board[i].setBounds(WIDTH/2-input_Width/2+5+x*board_Width,505+y*board_Width,board_Width,board_Width);
			board[i].setBorder(border1);
			board[i].setFont(subFont);
		}
		
		_key = setBoard(_key);
		strEncryption(_key,_str);
		
		
		panel.add(divStr);
		divStr.setBounds(WIDTH/2-input_Width/2+5, 850, input_Width, 50);
		divStr.setHorizontalAlignment(JLabel.LEFT);
		divStr.setFont(lableFont);
		
		
		panel.add(changeStr);
		changeStr.setBounds(WIDTH/2-input_Width/2+5, 910, input_Width, 50);
		changeStr.setHorizontalAlignment(JLabel.LEFT);
		changeStr.setFont(lableFont);
		
		JLabel cryptogramLabel = new JLabel("암호문");
		panel.add(cryptogramLabel);
		cryptogramLabel.setBounds(WIDTH/2-input_Width/2+5, 980, input_Width, 40);
		cryptogramLabel.setHorizontalAlignment(JLabel.LEFT);
		cryptogramLabel.setFont(lableFont);
		
		JLabel cryptogram = new JLabel("asdfsssssssssssse");
		panel.add(cryptogram);
		cryptogram.setBounds(WIDTH/2-input_Width/2+5, 1020, input_Width, 50);
		cryptogram.setHorizontalAlignment(JLabel.LEFT);
		cryptogram.setFont(subFont);
		
		
		size.setSize(WIDTH,HEIGHT+300);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(size);
		panel.setLayout(null);
		
		scroll = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 0, WIDTH, HEIGHT);
		add(scroll);
		
	}

	private String setBoard(String _key) {
		String keyForSet = "";
		boolean duplicationFlag = false;
		
		//키 중복 제거
		_key = _key.replace(" ", "");
		_key += "abcdefghijklmnopqrstuvwxyz"; 
		_key = _key.toUpperCase();
		_key=_key.replace("Z", "Q");
		
		for(int i=0; i<_key.length(); i++) {
			for(int j=0; j<keyForSet.length(); j++) {
				
				if(_key.charAt(i)==keyForSet.charAt(j)){
					duplicationFlag = true;
					break;
				}
			}
			if(!(duplicationFlag)) keyForSet += _key.charAt(i);
			duplicationFlag = false;
		}

		System.out.println();
		System.out.println("중복 제거 key: "+keyForSet);
		System.out.println(keyForSet.length());
		
		//board
		for(int i=0; i<keyForSet.length(); i++) {
			board[i].setText(Character.toString(keyForSet.charAt(i)));
		}		
		
		return keyForSet;
	}
	
	private void strEncryption(String _key, String _str) {
		
		
		//blanck, z check
		for( int i = 0 ; i < _str.length() ; i++ ) {
			if(_str.charAt(i)==' '){ //공백제거
				_str = _str.substring(0,i)+_str.substring(i+1,_str.length());
				blankCheck+=10;
			}
			else{
			
				blankCheck+=0;
			}
			if(_str.charAt(i)=='z'){ //z를 q로 바꿔줘서 처리함.
				_str = _str.substring(0,i)+'q'+_str.substring(i+1,_str.length());
				zCheck+=1;
			}
			else{
				zCheck+=0;
			}
		}
		
		Vector<Character> playFair = new Vector<Character>(); //암호화 전 문자  저장
		Vector<Character> encPlayFair = new Vector<Character>(); //암호화 문자 저장
		
		//두 글자씩 나누기
		for(int i=0; i<_str.length(); i+=2) {
			char cur = _str.charAt(i);
			char next = ' ';
			
			if(i<_str.length()-1) {
				next = _str.charAt(i+1);
			}else { //마지막 에 남았을 때 
				next = 'X';
			}
			
			if(cur == next) {
				playFair.add(cur);
				playFair.add('X');
				i-=1;
			}else {
				playFair.add(cur);
				playFair.add(next);
			}
		}
		
		String exStr = "";
		
		for(int i=0; i<playFair.size(); i++) {
			if(i%2==0 && i!=0) {
				exStr+=" ";
			}				
			exStr+=playFair.get(i);
		}
		divStr.setText(exStr);
		System.out.println(exStr);
		
		for(int i=0; i<playFair.size(); i+=2) { 
			int ax = 0;
			int bx = 0;
			int ay = 0;
			int by = 0;
			for(int j=0; j<_key.length(); j++) {
				if(playFair.get(i) == _key.charAt(j)) {
					ax = j%5;
					ay = j/5;
					System.out.print(j+" ");
					break;
				}
			}
			for(int j=0;j<_key.length(); j++) {
				if(playFair.get(i+1) == _key.charAt(j)) {
					bx = j%5;
					by = j/5;
					System.out.println(j);
					break;
				}
			}
			//암호화하기
			int n1 = ax*5+by;
			int n2 = bx*5+ay;
			System.out.println("n: "+ax+","+ay+"  "+bx+","+by);
		}
		//assassinator
		//Be careful for assassinator
	}
}
