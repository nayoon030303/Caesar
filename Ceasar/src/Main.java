import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TitlePage t = new TitlePage();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("��ȣŰ: ");
		String key = scan.nextLine();
		System.out.print("�Է� ����: ");
		String str = scan.nextLine();
		//System.out.println(key);
		//System.out.println(str);
		
		/*�ߺ� ���� ����*/
		String delStr = deDuplication(key);
		
		/*Board �����*/
		Vector<String> pwBoard = makePasswordBoard(delStr);
		
		
	}
	/*key �ߺ� ���� ���� �Լ�*/
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

	/*board�� ���� �ֱ�*/
	public static Vector<String> makePasswordBoard(String str) {	
		//String[] pwBoard = new String[26];
		Vector<String> pwBoard = new Vector<String>();
		for(int i=0; i<str.length(); i++) {
			pwBoard.add(Character.toString(str.charAt(i)));
		}
		
		int j = 65;
		for(int i=str.length(); i<26; i++) {
			String ch = Character.toString((char)j);
			if(!str.contains(ch)){//��ȣŰ�� ������� �ʴٸ�
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
		
		/*��� �ڵ�*/
		for(int i=0; i<pwBoard.size(); i++) {
			
			if(i%5==0) {
				System.out.println();
			}
			System.out.print(pwBoard.get(i)+"   ");
		} 
		
		return pwBoard;
		
	}

	/*��ȣȭ�ϱ�*/
	public static void encryption(String str) {
		
	}
}
