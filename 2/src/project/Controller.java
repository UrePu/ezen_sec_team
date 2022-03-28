package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Controller {
	
	static ArrayList<Member> memberlist = new ArrayList<Member>();
	static String[] wordList = new String[100];
 	Scanner scanner = new Scanner(System.in);
 	static List<String> firstwordlist = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안","송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주", "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양","변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금","옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
 	



 	
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
	
	// duplication test 
		public static boolean duplication_test (String id) {
			for(Member temp : memberlist) {
				if (temp.getId().equals(id)) {
					return false;
				} 
			}
			return true;
		}
	
	
	// sign_up method
	public static void sign_up (String id, String pw, String name, String contact) {
		Member member = new Member(id, pw, name, contact);
		memberlist.add(member);
	}
	
	// login method
	public static int login(String id, String pw) {
		if(id.equals("admin")) return 1;
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
	
	//id찾기 정준영
	public static String idsearch(String name, String contact) { // 이름, 연락처 받기
		for(Member temp : memberlist) {
			if(temp.getName().equals(name) && temp.getContact().equals(contact)) {
				return temp.getId(); // 이름, 연락처 일치하면
			}
		} return null; //일치하는 값이 없이 for문이 끝나면
	} // id찾기 e
	
	//pw찾기 정준영
	public static String pwsearch(String id, String contact) {
		for(Member temp : memberlist) {
			if(temp.getId().equals(id) && temp.getContact().equals(contact)) {
				return temp.getPw(); // 이름, 연락처 일치하면
			}
		} return null; //일치하는 값이 없이 for문이 끝나면
	} // id찾기 e
	
	public static String randomfirstword() {
		Collections.shuffle(firstwordlist);
		return firstwordlist.get(0);
	}
	
	//김선제 - gameStart 메소드 작성//
	public static boolean gameStart(String id, String word) { 	// id, 및 입력한 word 받아오기
		if(wordList[0] == null) {								// wordList의 [0] 값이 null 이면 						
			wordList[0] = word;									//[0] 값에 word 넣기
			System.out.println("입력받은 단어: " + word);
			return true;
		}else {													//wordList의 [0] 값이 null 이 아니면
			int index = -1;
			for(String temp : wordList) {
				if(temp != null) {
					index ++;									//wordList 에 저장되어있는 수 - 1만큼 index값 저장
				}
				if(temp != null && temp.equals(word)) {
					return false;								//wordList 에 저장되어있는 값중 중복이 있을시에 게임 종료
				}
			}
	        char lastChar = 
	        		wordList[index].charAt(wordList[index].length() - 1);	//wordList 의 마지막 글자의 뒷글자 lastChar 저장
	        char firstChar = word.charAt(0);								//입력받은 word의 첫글자 firstChar 저장
	        if(lastChar == firstChar ) {									//lastChar 이 firstChar 이면 저장
	        	System.out.println("입력받은 단어: " + word);
	        	wordList[index + 1] = word;
	        }else {															////lastChar 이 firstChar 이 아니면 게임종료
	        	return false;
	        }
			
		}
		return true;
	}
	//김선제- 점수 저장
	public static void countSave(String id, int index) {
		for(Member temp : memberlist) {
			if(temp != null && temp.getId().equals(id)) {
				if(index > temp.getCount())
					temp.setCount(index);
			}
		}
		
	}
	// wordList 초기화
	public static void initialization(String id) {
		int index = 0;
		for(String temp : wordList) {
			if(temp != null) {
				Controller.wordList[index] = null;
				index++;
			}
		}
		System.out.println("내 점수: " + (index));
		Controller.countSave(id, index);
	}
	
	//김선제- 점수 보기
	
	public static void seeScore(String id) {
		for(Member temp : memberlist) {
			if(temp != null && temp.getId().equals(id)) {
			System.out.println( temp.getCount());
			}
		}
	}
	public static void fileSave() { // 정준영 저장 s
        FileOutputStream fileOutputStream;
        try {
           fileOutputStream = new FileOutputStream("c:/temp/java/test/test.txt",true);
           for(Member temp : memberlist) {
              String output = (temp.getId()+","+temp.getPw()+","+temp.getName()+","+temp.getContact()+","+temp.getCount()+"\n");
           
           fileOutputStream.write(output.getBytes()); // 바이트화 해서 기록
              }
           } catch (Exception e) {}
        
     } // 저장 e
     
	public static void load() { // 정준영 불러오기 s
        try {
           FileInputStream fileInputStream = new FileInputStream("c:/temp/java/test/test.txt");
           byte[] bytes = new byte[1024]; // 바이트 배열 선언
           fileInputStream.read(bytes);
           String file = new String(bytes); // 파일내용 선언
           String[] list = file.split("\n"); // \n 기준으로 자르기
           for(int i = 0; i<list.length; i++) { // list 끝까지 한번씩 차례차례
               String[] ma = file.split(",",5); // , 를 기준으로 5개까지 잘라서 저장
               String C=String.valueOf(ma[4]).trim();
                        Member member = new Member(ma[0], ma[1], ma[2], ma[3], Integer.parseInt(C));
                        // 아이디, 비밀번호, 이름, 전화번호, 점수
                        // 문자열 --> 정수형 변환 
               memberlist.add(member);   // 리스트 저장
           } // for e
        } catch (Exception e) {
        }
     } // 불러오기 e
     
     //랭킹 정준영
     public static void ranking() {

    	 HashMap<Integer, String> rank = new HashMap<>();
    	 TreeSet<Integer> scores = new TreeSet<>();
    	 for(Member temp : memberlist) {
    		 scores.add(temp.getCount()); // 점수값 반복 저장
    	 }
    	 
    	 NavigableSet<Integer> desc = scores.descendingSet(); // 내림차순 정렬해서 desc에 저장
    	 for(Member temp : memberlist) { // 멤버리스트 전체에서
    		 rank.put(temp.getCount(), temp.getId()); // 점수랑 아이디 저장(자동 정렬)
    	 }
    	 //출력파트
    	 int i = 1;
    	 for(Integer d : desc) { System.out.println(i+"위 : "+rank.get(d)+", "+d+"점"); i++;}
     }
}
