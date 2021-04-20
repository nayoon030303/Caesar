import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TitlePage t = new TitlePage();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("암호키: ");
		String key = scan.nextLine();
		System.out.print("입력 문장: ");
		String str = scan.nextLine();
		//System.out.println(key);
		//System.out.println(str);
		
		/*중복 문자 제거*/
		String delStr = deDuplication(key);
		
		/*Board 만들기*/
		Vector<String> pwBoard = makePasswordBoard(delStr);
		
		
	}
	/*key 중복 문자 제거 함수*/
	public static String deDuplication(String key) {
		key = key.toUpperCase();
		String delStr = "";
		for(int i=0; i<key.length()-1; i++) {
			String current = Character.toString(key.charAt(i)); //char->String
			if(!delStr.contains(current)){
				delStr+=current+"";
			}
		}
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
				System.out.println(ch);
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

	/*암호화하기*/
	public static void encryption(String str) {
		
	}
}
