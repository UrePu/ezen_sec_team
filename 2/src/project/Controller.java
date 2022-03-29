package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Controller {
	//리스트
	static ArrayList<Member> memberlist = new ArrayList<Member>();
	static String[] wordList = new String[100];
	Scanner scanner = new Scanner(System.in);
 	static List<String> firstwordlist = Arrays.asList(
 			"김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", 
 			"한", "오", "서", "신", "권", "황", "안","송", "류", "전",
 			"홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", 
 			"남", "심", "노", "정", "하", "곽", "성", "차", "주", "우", 
 			"구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", 
 			"채", "원", "천", "방", "공", "강", "현", "함", "변", "염", 
 			"양","변", "여", "추", "노", "도", "소", "신", "석", "선", 
 			"설", "마", "길", "주", "연", "방", "위", "표", "명", "기", 
 			"반", "왕", "금","옥", "육", "인", "맹", "제", "모", "장", 
 			"남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
	
	//메소드
		// 회원가입
	public static int id_valid (String id) {
		// id 정규식  "/^[a-zA-Z0-9]{1,12}$/"  -> 12글자 이하 숫자, 영문
		String regex = "^[a-zA-Z0-9]{1,12}$"; 
		boolean result = Pattern.matches(regex, id);
		
		if (result) {return 1;} 
		else {return 0;}
	}
	public static int pw_valid (String pw) {
		// pw 정규식 "/^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\d~!@#$%^&*()+|=]{8,}/" -> 8글자 이상 숫자, 영문, 특수문자 반드시 포함
		String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,}$";
		boolean result = Pattern.matches(regex, pw);
		
		if (result) {return 1;} 
		else {return 0;}
	}
	
	// id 중복 체크
	public static boolean duplication_test (String id) {
		for(Member temp : memberlist) {
			if (temp.getId().equals(id)) {
				return false;
			} 
		}
		return true;
	}
	
		// sign_up method
	public static void sign_up (String id, String password, String name, String phone) {
		Member member = new Member(id, password, name, phone);
		memberlist.add(member); save();
	}

		// login method
	public static int login(String id, String pw) {
		for (Member temp : memberlist) {
			if (temp.getId().equals(id) ) {
				if(temp.getPassword().equals(pw))return 1;
				else return 2;
			}
		}
		return 3;
	}
	
	public static String randomfirstword() {
		Collections.shuffle(firstwordlist);
		return firstwordlist.get(0);
	}
	
	
	//김선제 - gameStart 메소드 작성//
	public static boolean gameStart(String id, String word) {
		
		if(wordList[0] == null) {
			wordList[0] = word;
			System.out.println("입력받은 단어: " + word);
			return true;
		}
		else {	
			int index = -1;
			
			for(String temp : wordList) {
				if(temp != null) {index ++;}
				if(temp != null && temp.equals(word)) {
					return false;
				}
			}
	        
			char lastChar = wordList[index].charAt(wordList[index].length() - 1);
	        char firstChar = word.charAt(0);
	        
	        if(lastChar == firstChar ) {
	        	System.out.println("입력받은 단어: " + word);
	        	wordList[index + 1] = word;
	        }
	        else return false;	
		}
		return true;
	}
	//김선제- 점수 저장
	public static void gameSave(String id, int index) {
		for(Member temp : memberlist) {
			if(temp != null && temp.getId().equals(id)) {
				if(index > temp.getCount())
					temp.setCount(index); save();
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
		Controller.gameSave(id, index);
	}
	
	//김선제- 점수 보기

	public static void seeScore(String id) {
		for(Member temp : memberlist) {
			if(temp != null && temp.getId().equals(id)) {
			System.out.println( temp.getCount());

			}
		}
	}
	
	public static void save() { // 정준영 저장 s
        try {
           FileOutputStream fileOutputStream = new FileOutputStream("c:/temp/java/test/test.txt");
           for(Member temp : memberlist) {
              String output = (temp.getId()+","+temp.getPassword()+","+
              temp.getName()+","+temp.getPhone()+","+temp.getCount()+"\n");
           
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
            for(int i = 0; i<list.length-1; i++) { // list 끝까지 한번씩 차례차례
            	String[] ma = list[i].split(",",5); // , 를 기준으로 5개까지 잘라서 저장
            	String C=String.valueOf(ma[4]).trim();
            	Member member = new Member(ma[0], ma[1], ma[2], ma[3], Integer.parseInt(C));
            	// 아이디, 비밀번호, 이름, 전화번호, 점수
            	// 문자열 --> 정수형 변환 
                memberlist.add(member);   // 리스트 저장
           } // for e
        } catch (Exception e) {}
        
        
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
    	 System.out.println("===============랭킹===============");
    	 for(Integer d : desc) { System.out.println(i+"위 : "+rank.get(d)+", "+d+"점"); i++;}
     }
	
	// 아이디찾기
 	//id찾기 정준영
 	public static String idsearch(String name, String contact) { // 이름, 연락처 받기
 		for(Member temp : memberlist) {
 			if(temp.getName().equals(name) && temp.getPhone().equals(contact)) {
 				return temp.getId(); // 이름, 연락처 일치하면
 			}
 		} return null; //일치하는 값이 없이 for문이 끝나면
 	} // id찾기 e
 	
 	// 비밀번호찾기 
	//pw찾기 정준영
	public static String pwsearch(String id, String contact) {
		for(Member temp : memberlist) {
			if(temp.getId().equals(id) && temp.getPhone().equals(contact)) {
				return temp.getPassword(); // 이름, 연락처 일치하면
				}
			} 
		return null; //일치하는 값이 없이 for문이 끝나면
	}
	
	public static void game(String id) {
		try {
			while(true) {
				System.out.println(" ===================================");
				System.out.println("\t\t\t\t끝말잇기 게임");
				System.out.println("\t\t1. 시작 2. 내 점수보기 3. 로그아웃");
				System.out.println(" ===================================");
				System.out.print(">>>>>: "); int ch = App.scanner.nextInt();
				
				boolean result = false;
				
				if(ch == 1) {
					System.out.println(" ===================================");
					System.out.println("\t\t\t\t난이도 선택");
					System.out.println("\t\t1. 쉬움 2. 보통 3. 어려움"); 	
					System.out.println(" ===================================");
					int level = App.scanner.nextInt();
					System.out.println("게임 시작");
					String firstword = Controller.randomfirstword();
					System.out.print("첫번째 글자 : " + firstword + "\n");
					
					long timelimit = 20;
						
					while(true) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss",Locale.KOREA);
						Date date = new Date();
						String starttime = dateFormat.format(date);
						Date d1 = dateFormat.parse(starttime);
						System.out.print("입력 > "); 	String word = App.scanner.next();
						Date date1 = new Date();
						String endtime = dateFormat.format(date1);
						Date d2 = dateFormat.parse(endtime);
				
						long diff = d2.getTime() - d1.getTime();
						long sec = diff / 1000;

						if (sec < timelimit) {
							result = gameStart(id, word);
							if (timelimit > 4) { //시간제한이 4초보다 많을 때에
								if(level==1) {timelimit-=1;} // 쉬움 난이도에서 1초씩 감소
								if(level==2) {timelimit-=2;} // 보통 난이도에서 2초씩 감소
								if(level==3) {timelimit-=4;} // 어려움 난이도에서 4초씩 감소
							} 
							System.out.println("시간제한 : " + timelimit);
						} else {
							System.err.println("시간초과");
							result = false;
						}							
						
						if(!result) {	
							System.err.println("게임 종료");
							Controller.initialization(id);
							break;
						}
					}
				} else if(ch == 2) {
					System.out.println(" ===================================");
					System.out.println("\t\t\t\t점수 확인");
					System.out.println(" ===================================");
					seeScore(id);
				} else if(ch == 3) {break;}
			}
		}
	catch(Exception e) {App.scanner = new Scanner(System.in);}
	}
}
