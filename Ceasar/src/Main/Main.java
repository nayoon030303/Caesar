package Main;
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
		
		System.out.print("��ȣŰ: ");
		key = scan.nextLine();
		System.out.print("�Է� ����: ");
		input = scan.nextLine();
		
		
		//System.out.println(key);
		//System.out.println(str);
		
		/*key �ߺ� ���� ����*/
		String delStr = deDuplication(key);
		
		/*Board �����*/
		Vector<String> pwBoard = makePasswordBoard(delStr);
		
		//���� ��ȯ
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
		System.out.println(zCheck);
		System.out.println(blankCheck);
		//Vector<String>  = makeTwoLetters(input);
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

	/*2��¥�� �����*/
	public static Vector<String> makeTwoLetters(String input) {
		//String[] str = input.replace(" ", "").toUpperCase().split("");
		
		
		
		Vector<String> vectorStr = new Vector<String>();
		
		/*for(int i=0; i<str.length; i+=2) {
			String cur = str[i];
			String next =null;
			if(i<str.length-1) {
				next = str[i+1];
			}else {
				next = "X";
			}
			
			if(cur.equals(next)) {
				vectorStr.add(cur);
				vectorStr.add("X");
				i-=1;
				//vectorStr.add(next);
			}else {
				vectorStr.add(cur);
				vectorStr.add(next);
			}
		}
		System.out.println();
		
		for(int i=0; i<vectorStr.size(); i++) {
			if(i%2==0)
				System.out.println();
			System.out.print(vectorStr.get(i)+" ");
		}*/
		
		return vectorStr;
	}
}
