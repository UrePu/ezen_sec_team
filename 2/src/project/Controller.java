package project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import project_�����ձ�.Member;

public class Controller {
	
	static ArrayList<Member> memberlist = new ArrayList<Member>();
	static String[] wordList = new String[100];
 	Scanner scanner = new Scanner(System.in);
	// id_valid test
	public static int id_valid (String id) {
		// id ���Խ�  "/^[a-zA-Z0-9]{1,12}$/"  -> 12���� ���� ����, ����
		String regex = "^[a-zA-Z0-9]{1,12}$"; 
		boolean result = Pattern.matches(regex, id);
		
		if (result) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	// pw_valid text
	public static int pw_valid (String pw) {
		// pw ���Խ� "/^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\d~!@#$%^&*()+|=]{8,}/" -> 8���� �̻� ����, ����, Ư������ �ݵ�� ����
		String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,}$";
		boolean result = Pattern.matches(regex, pw);
		
		if (result) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	
	// sign_up method
	public static void sign_up (String id, String pw, String name, String contact) {
		Member member = new Member(id, pw, name, contact);
		memberlist.add(member);
	}
	
	// login method
	public static int login(String id, String pw) {
		for (Member temp : memberlist) {
			if (temp.getId().equals(id) && temp.getPw().equals(pw)) {
				return 1;
			} else if (temp.getId().equals(id) && !temp.getPw().equals(pw)) {
				return 2;
			} else if (!temp.getId().equals(id) && temp.getPw().equals(pw)) {
				return 3;
			} 
		}
		return 0;
	}
	
	//�輱�� - gameStart �޼ҵ� �ۼ�//
	public static boolean gameStart(String id, String word) { // id, �� �Է��� word �޾ƿ���
		
		if(wordList[0] == null) {
			wordList[0] = word;
			System.out.println("�Է¹��� �ܾ�: " + word);
			return true;
		}else {
			int index = -1;
			for(String temp : wordList) {
				if(temp != null) {
					index ++;
				}
				if(temp != null && temp.equals(word)) {
					return false;
				}
			}
	        char lastChar = wordList[index].charAt(wordList[index].length() - 1);
	        char firstChar = word.charAt(0);
	        if(lastChar == firstChar ) {
	        	System.out.println("�Է¹��� �ܾ�: " + word);
	        	wordList[index + 1] = word;
	        }else {
	        	return false;
	        }
			
		}
		return true;
	}
	//�輱��- ���� ����
	public static void save(String id, int index) {
		for(Member temp : memberlist) {
			if(temp != null && temp.getId().equals(id)) {
				if(index > temp.getCount())
					temp.setCount(index);
			}
		}
		
	}
	// wordList �ʱ�ȭ
	public static void initialization(String id) {
		int index = 0;
		for(String temp : wordList) {
			if(temp != null) {
				Controller.wordList[index] = null;
				index++;
			}
		}
		System.out.println("�� ����: " + (index -1));
		Controller.save(id, index -1);
	}
	
	//�輱��- ���� ����
	
	public static void seeScore(String id) {
		for(Member temp : memberlist) {
			if(temp != null && temp.getId().equals(id)) {
			System.out.println( temp.getCount());

			}
		}
	}

}
