package project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
	
	static ArrayList<Member> memberlist = new ArrayList<Member>();
	static String[] wordList = new String[100];
 	Scanner scanner = new Scanner(System.in);
	// id_valid test
	public static int id_valid (String id) {
		// id 정규식  "/^[a-zA-Z0-9]{1,12}$/"  -> 12글자 이하 숫자, 영문
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
		// pw 정규식 "/^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\d~!@#$%^&*()+|=]{8,}/" -> 8글자 이상 숫자, 영문, 특수문자 반드시 포함
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
	
	//김선제 - gameStart 메소드 작성//
	public static boolean gameStart(String id, String word) {
		
		if(wordList[0] == null) {
			wordList[0] = word;
			System.out.println("입력받은 단어: " + word);
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
	        	System.out.println("입력받은 단어: " + word);
	        	wordList[index + 1] = word;
	        }else {
	        	return false;
	        }
			
		}
		return true;
	}
	//김선제- 점수 저장
	public static void save(String id, int index) {
		for(Member temp : memberlist) {
			if(temp != null && temp.getId().equals(id)) {
				if(index > temp.getScore())
					temp.setScore(index);
			}
		}
		
	}
	//김선제- 점수 보기

	public static void seeScore(String id) {
		for(Member temp : memberlist) {
			if(temp != null && temp.getId().equals(id)) {
			System.out.println( temp.getScore());

			}
		}
	}

}
