package kr.hs.page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class EncryptionPage extends JFrame {

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
	private JLabel divStr = new JLabel("2개씩 자르기");
	private JLabel strEncryp = new JLabel("암호화된 문자");
	private JButton btnDecryption = new JButton("복호화 하기");
	private JLabel strDecryLabel = new JLabel("복호문");
	private JLabel strDecry = new JLabel("복호문");
	private JPanel panel = new JPanel();
	private Dimension size = new Dimension();
	private JScrollPane scroll;
	//Encryption
	private String encryption;
	private String zCheck ="";
	private String blankCheck="";
	private int blankCheckCount=0;
	private boolean oddFlag = false; 
	private char alphabetBoard[][] = new char[5][5];
	
	//
	private String decryption;
	
	//암호화
	public EncryptionPage(String _key, String _str) {
		
		_key = _key.toLowerCase();
		_str = _str.toLowerCase();
	
		
		
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
		
	
		
		panel.add(divStr);
		divStr.setBounds(WIDTH/2-input_Width/2+5, 850, input_Width, 50);
		divStr.setHorizontalAlignment(JLabel.LEFT);
		divStr.setFont(lableFont);
		
		
		JLabel strEncrypLabel = new JLabel("암호문");
		panel.add(strEncrypLabel);
		strEncrypLabel.setBounds(WIDTH/2-input_Width/2+5, 950, input_Width, 40);
		strEncrypLabel.setHorizontalAlignment(JLabel.LEFT);
		strEncrypLabel.setFont(lableFont);
		
		
		panel.add(strEncryp);
		strEncryp.setBounds(WIDTH/2-input_Width/2+5, 990, input_Width, 50);
		strEncryp.setHorizontalAlignment(JLabel.LEFT);
		strEncryp.setFont(lableFont);
		

		
		panel.add(btnDecryption);
		btnDecryption.setBounds(WIDTH/2-input_Width/2+5, 1070, 150, 50);
		btnDecryption.setFocusable(false);
		btnDecryption.setBorderPainted(false);
		btnDecryption.setForeground(Color.WHITE);
		btnDecryption.setBackground(new Color(255, 187,187));
		btnDecryption.setHorizontalAlignment(JLabel.LEFT);
		btnDecryption.setFont(lableFont);
		btnDecryption.addActionListener(new EventHandler());

		
		
		
		
		size.setSize(WIDTH,HEIGHT+500);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(size);
		panel.setLayout(null);
		
		scroll = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 0, WIDTH, HEIGHT);
		add(scroll);
		
		
		
		
		setBoard(_key);
		
		for( int i = 0 ; i < _str.length() ; i++ ) 
		{
			if(_str.charAt(i)==' ') //공백제거
			{
				_str = _str.substring(0,i)+_str.substring(i+1,_str.length());
				blankCheck+=10;
			}
			else
			{
				blankCheck+=0;
			}
			if(_str.charAt(i)=='z') //z를 q로 바꿔줘서 처리함.
			{
				_str = _str.substring(0,i)+'q'+_str.substring(i+1,_str.length());
				zCheck+=1;
			}
			else 
			{
				zCheck+=0;
			}
		}
		
		encryption = strEncryption(_key, _str);//암호화
		strEncryp.setText(encryption);
		for( int i = 0 ; i < encryption.length() ; i++ ) 
		{
			if(encryption.charAt(i)==' ') //공백제거
				encryption = encryption.substring(0,i)+encryption.substring(i+1,encryption.length());
		}
		
		decryption = strDecryption(_key, encryption, zCheck);
		
		for( int i = 0 ; i < decryption.length() ; i++)
		{
			if(blankCheck.charAt(i)=='1')
			{
				decryption = decryption.substring(0,i)+" "+decryption.substring(i,decryption.length());
			}
		}
		
		System.out.println("복호화된 문자열 : " + decryption);
		
		
	}
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnDecryption) {
				//복호문
				panel.add(strDecryLabel);
				strDecryLabel.setBounds(WIDTH/2-input_Width/2+5,1200 , input_Width, 40);
				strDecryLabel.setHorizontalAlignment(JLabel.LEFT);
				strDecryLabel.setFont(lableFont);
		
				
				
				panel.add(strDecry);
				strDecry.setBounds(WIDTH/2-input_Width/2+5, 1250, input_Width, 50);
				strDecry.setHorizontalAlignment(JLabel.LEFT);
				strDecry.setFont(lableFont);	
				strDecry.setText(decryption);
			}
			
		}
		
	}
	private void setBoard(String key) {
		String keyForSet = "";					// 중복된 문자가 제거된 문자열을 저장할 문자열.
		boolean duplicationFlag = false;		// 문자 중복을 체크하기 위한 flag 변수.
		int keyLengthCount = 0;					// alphabetBoard에 keyForSet을 넣기 위한 count변수.
		
		key += "abcdefghijklmnopqrstuvwxyz"; 	// 키에 모든 알파벳을 추가.

		
		// 중복처리
		for( int i = 0 ; i < key.length() ; i++ ) 
		{
			for( int j = 0 ; j < keyForSet.length() ; j++ )
			{
				if(key.charAt(i)==keyForSet.charAt(j))
				{
					duplicationFlag = true;
					break;
				}
			}
			if(!(duplicationFlag)) keyForSet += key.charAt(i);
			duplicationFlag = false;
		}
		//배열에 대입
		for( int i = 0 ; i < alphabetBoard.length ; i++ )
		{
			for( int j = 0; j <alphabetBoard[i].length ; j++ )
			{
				alphabetBoard[i][j] = keyForSet.charAt(keyLengthCount++);
			}
		}		
		//배열에 대입
		for( int i = 0 ; i < alphabetBoard.length ; i++ )
		{
			for( int j = 0; j <alphabetBoard[i].length ; j++ )
			{
				String s = alphabetBoard[i][j]+"";
				board[i*5+j].setText(s);
				
			}
			
		}
		
	}
	
	
	//복호화
	private String strDecryption(String key, String str, String zCheck) {
		ArrayList<char[]> playFair = new ArrayList<char[]>(); //바꾸기 전 쌍자암호를 저장할 곳
		ArrayList<char[]> decPlayFair = new ArrayList<char[]>(); //바꾼 후의 쌍자암호 저장할 곳
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0; //쌍자 암호 두 글자의 각각의 행,열 값
		String decStr ="";

		int lengthOddFlag = 1;
		
		
		//암호문 넣기
		for( int i = 0 ; i < str.length() ; i+=2 )
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			tmpArr[1] = str.charAt(i+1);
			playFair.add(tmpArr);
		}
		
		
		for(int i = 0 ; i < playFair.size() ; i++ )
		{

			char[] tmpArr = new char[2];
			for( int j = 0 ; j < alphabetBoard.length ; j++ )
			{
				for( int k = 0 ; k < alphabetBoard[j].length ; k++ )
				{
					if(alphabetBoard[j][k] == playFair.get(i)[0])
					{
						x1 = j;
						y1 = k;
					}
					if(alphabetBoard[j][k] == playFair.get(i)[1])
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			if(x1==x2) //행이 같은 경우 각각 바로 아래열 대입
			{
				tmpArr[0] = alphabetBoard[x1][(y1+4)%5];
				tmpArr[1] = alphabetBoard[x2][(y2+4)%5];
			}
			else if(y1==y2) //열이 같은 경우 각각 바로 옆 열 대입
			{
				tmpArr[0] = alphabetBoard[(x1+4)%5][y1];
				tmpArr[1] = alphabetBoard[(x2+4)%5][y2];
			}
			else //행, 열 다른경우 각자 대각선에 있는 곳.
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}
			
			decPlayFair.add(tmpArr);
			
		}
		
		for(int i = 0 ; i < decPlayFair.size() ; i++) //중복 문자열 돌려놓음
		{
			if(i!=decPlayFair.size()-1 && decPlayFair.get(i)[1]=='x' 
					&& decPlayFair.get(i)[0]==decPlayFair.get(i+1)[0])
			{	
				decStr += decPlayFair.get(i)[0];
			}
			else
			{
				decStr += decPlayFair.get(i)[0]+""+decPlayFair.get(i)[1];
			}
		}
		
		
		
		for(int i = 0 ; i < zCheck.length() ; i++ )//z위치 찾아서 q로 돌려놓음
		{
			if( zCheck.charAt(i) == '1' ) 
				decStr = decStr.substring(0,i)+'z'+decStr.substring(i+1,decStr.length());
			
		}
		
		
		
		if(oddFlag) decStr = decStr.substring(0,decStr.length()-1);
		
		/*
		 //띄어쓰기
		for(int i = 0 ; i < decStr.length(); i++)
		{
			if(i%2==lengthOddFlag){
				decStr = decStr.substring(0, i+1)+" "+decStr.substring(i+1, decStr.length());
				i++;
				lengthOddFlag = ++lengthOddFlag %2;
			}
		}
		*/
		return decStr;
	}
	
	//암호화
	private String strEncryption(String board, String str) {
		ArrayList<char[]> playFair = new ArrayList<char[]>();
		ArrayList<char[]> encPlayFair = new ArrayList<char[]>();
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
		String encStr ="";
		
		
		
		for( int i = 0 ; i < str.length() ; i+=2 ) // arraylist 세팅
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			try{
				if( str.charAt(i) == str.charAt(i+1)) //글이 반복되면 x추가
				{
					tmpArr[1] = 'x';
					i--;
				}else{
					tmpArr[1] = str.charAt(i+1);
				}
			}catch(StringIndexOutOfBoundsException e)
			{
				tmpArr[1] = 'x'; 
				oddFlag = true;
			}
			playFair.add(tmpArr);
		}
		String div = "";
		for(int i = 0 ; i < playFair.size() ; i++ )
		{
			div+=(playFair.get(i)[0]+""+playFair.get(i)[1]+" ");
			System.out.print(playFair.get(i)[0]+""+playFair.get(i)[1]+" ");
		}
		System.out.println();
		divStr.setText(div);
		for(int i = 0 ; i < playFair.size() ; i++ )
		{

			char[] tmpArr = new char[2];
			for( int j = 0 ; j < alphabetBoard.length ; j++ ) //쌍자암호의 각각 위치체크
			{
				for( int k = 0 ; k < alphabetBoard[j].length ; k++ )
				{
					if(alphabetBoard[j][k] == playFair.get(i)[0])
					{
						x1 = j;
						y1 = k;
					}
					if(alphabetBoard[j][k] == playFair.get(i)[1])
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			
			if(x1==x2) //행이 같은경우
			{
				tmpArr[0] = alphabetBoard[x1][(y1+1)%5];
				tmpArr[1] = alphabetBoard[x2][(y2+1)%5];
			}
			else if(y1==y2) //열이 같은 경우
			{
				tmpArr[0] = alphabetBoard[(x1+1)%5][y1];
				tmpArr[1] = alphabetBoard[(x2+1)%5][y2];
			} 
			else //행, 열 모두 다른경우
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}
			
			encPlayFair.add(tmpArr);
			
		}
		
		for(int i = 0 ; i < encPlayFair.size() ; i++)
		{
			encStr += encPlayFair.get(i)[0]+""+encPlayFair.get(i)[1]+" ";
		}
		
		
		return encStr;
		
		
	}
}
