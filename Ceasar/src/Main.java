
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TitlePage t = new TitlePage();
		Scanner scan = new Scanner(System.in);
		
		String blankCheck="";
		String zCheck ="";
		String key ="";
		String input ="";
		
		System.out.print("암호키: ");
		key = scan.nextLine();
		System.out.print("입력 문장: ");
		input = scan.nextLine();
		
		
		//System.out.println(key);
		//System.out.println(str);
		
		/*key 중복 문자 제거*/
		key = deDuplication(key);
		
		/*Board 만들기*/
		Vector<String> pwBoard = makePasswordBoard(key);
		
		//문자 변환
		input= input.toUpperCase();
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) ==' ') {
				input = input.substring(0,i)+input.substring(i+1,input.length());
				blankCheck+="10";
			}else {
				blankCheck+="0";
			}
			
			if(input.charAt(i)=='Z') {
				input = input.substring(0,i)+"Q"+input.substring(i+1,input.length());
				zCheck+="1";
			}else {
				zCheck+="0";
			}
		}
		
		System.out.println();
		System.out.println(input);
		//System.out.println(zCheck);
		//System.out.println(blankCheck);
		//Vector<String>  = makeTwoLetters(input);
		
		
		//두글자씩 자르기
		Vector<String> vectorStr = new Vector<String>();
		for(int i=0; i<input.length(); i+=2) {
			String cur = Character.toString(input.charAt(i));
			String next = null;
			if(i<input.length()-1) {
				next = Character.toString(input.charAt(i+1));
			}else {
				next = "X";
			}
			
			if(cur.equals(next)) {
				vectorStr.add(cur);
				vectorStr.add("X");
				i-=1;
			}else {
				vectorStr.add(cur);
				vectorStr.add(next);
			}
		}
		
		//출력 
		for(int i=0; i<vectorStr.size(); i++) {
			if(i%2==0 && i!=0)
				System.out.print(" ");
			System.out.print(vectorStr.get(i));
		}
		
		makePassword(vectorStr,pwBoard);
	}
	
	/*key 중복 문자 제거 함수*/
	public static String deDuplication(String key) {
		key = key.toUpperCase();
		key = key.replace(" ", "");
		String delStr = "";
		for(int i=0; i<key.length(); i++) {
			String current = Character.toString(key.charAt(i)); //char->String
			if(!delStr.contains(current)){
				delStr+=current;
			}
		}
		return delStr;
	}

	/*board 만들기*/
	public static Vector<String> makePasswordBoard(String str) {	
		
		Vector<String> pwBoard = new Vector<String>();
		for(int i=0; i<str.length(); i++) {
			pwBoard.add(Character.toString(str.charAt(i)));
		}
		
		int j = 65;
		for(int i=str.length(); i<26; i++) {
			String ch = Character.toString((char)j);
			if(!str.contains(ch)){//암호키에 들어있지 않다면
				pwBoard.add(ch);
			}else {
				i--;
			}
			j++;
		}
		
		for(int i=0; i<pwBoard.size(); i++) {
			if(pwBoard.get(i).equals("Q")) {
				pwBoard.set(i, "Q/Z"); 
			}else if(pwBoard.get(i).equals("Z")) {
				pwBoard.remove(i);
			}
		}
		
		/*출력 코드*/
		for(int i=0; i<pwBoard.size(); i++) {
			
			if(i%5==0) {
				System.out.println();
			}
			System.out.print(pwBoard.get(i)+"   ");
		} 
		
		return pwBoard;
		
	}

	public static void makePassword(Vector<String> input, Vector<String> board) {
		
		for(int i=0; i<input.size(); i+=2) {
			String cur = input.get(i);
			String nex = input.get(i+1);
			int curIndex = 0,nexIndex = 0;
			
			for(int j=0; j<board.size(); j++) {
				if((board.get(i)).equals(cur)) {
					curIndex = i;
				}else if((board.get(i)).equals(nex)) {
					nexIndex = i;
				}
			}
			System.out.println(curIndex+" "+nexIndex);
			
		}
	}
}
