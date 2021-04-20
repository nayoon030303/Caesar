import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TitlePage t = new TitlePage();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("암호키: ");
		String str = scan.next();
		System.out.println(str);
		
		/*중복 문자 제거*/
		String delStr = deDuplication(str);
		
		/*Board 만들기*/
		Vector<String> pwBoard = makePasswordBoard(delStr);
		
		
	}
	/*중복 문자 제거 함수*/
	public static String deDuplication(String str) {
		String delStr = str.toUpperCase();
		
		for(int i=0; i<delStr.length()-1; i++) {
			String current = Character.toString(delStr.charAt(i));
			String next = Character.toString(delStr.charAt(i+1));
			if(current.equals(next)) {
				delStr = delStr.replaceFirst(current, "");
				i = -1;
				//System.out.println(current+", "+next);
			}
		}
		System.out.println(delStr);
		return delStr;
	}

	/*board에 문자 넣기*/
	public static Vector<String> makePasswordBoard(String str) {	
		//String[] pwBoard = new String[26];
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
}
