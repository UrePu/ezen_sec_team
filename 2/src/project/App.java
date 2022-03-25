package project;

import java.util.Scanner;


public class App {
	
	public static boolean inputCheck = false;
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			
			while(true) {
				System.out.println("===============================");
				System.out.println("              끝말잇기");
				System.out.println("===============================");
				System.out.println("1. 회원가입 2. 로그인 3. ID/PW 찾기\n");
				System.out.print("선택 > "); 		int ch = scanner.nextInt();
				
				if (ch == 1) {
					System.out.println("===============================");
					System.out.println("              회원가입");
					System.out.println("===============================");
					System.out.println("ID는 12글자 이하 / PW는 8글자 이상 숫자, 영문, 특수문자 반드시 포함");
					System.out.print("ID 입력 : ");				String id = scanner.next();
					System.out.print("PW 입력 : ");				String pw = scanner.next();
					System.out.print("이름 입력 : ");				String name = scanner.next();
					System.out.print("전화번호 입력 : ");			String contact = scanner.next();
					
					if (Controller.id_valid(id) == 0) {
						System.err.println("\n아이디는 12글자 이하로 입력해주세요.\n");
					} else if (Controller.id_valid(id) == 1 && Controller.pw_valid(pw) == 0) {
						System.err.println("\n비밀번호는 8글자 이상 숫자, 영문, 특수문자를 반드시 포함해 주세요.");
					} else if (Controller.id_valid(id) == 1 && Controller.pw_valid(pw) == 1) {
						boolean result = Controller.duplication_test(id);
						if (result) {
							Controller.sign_up(id, pw, name, contact);
							System.out.println("\n회원가입 성공");
						} else {
							System.err.println("이미 존재하는 아이디입니다.");
						}
					}
				} else if (ch == 2){
					System.out.println("===============================");
					System.out.println("              로그인");
					System.out.println("===============================");
					System.out.print("ID : ");			String id = scanner.next();
					System.out.print("PW : ");			String pw = scanner.next();
					int result = Controller.login(id, pw);
					if (result == 1) {
						System.out.println("\n로그인 성공\n");
						System.out.println("\n1. 게임시작 2. 로그아웃");
						game(id);
					} else if (result == 2) {
						System.err.println("\n비밀번호 오류\n");
					} else if (result == 3) {
						System.err.println("\n아이디 오류\n");
					}
				} else if (ch == 3) {
					System.out.println("1. ID찾기 2. PW찾기"); int s = scanner.nextInt();
					if(s==1) { // id찾기
						System.out.println("===============================");
						System.out.println("           ID찾기 페이지");
						System.out.println("===============================");
						System.out.println("이름 입력 : "); String name = scanner.next();
						System.out.println("전화번호 입력 : "); String contact = scanner.next();
						String id=Controller.idsearch(name, contact);
						if(id==null) { // 리턴값이 null이면
							System.out.println("일치하는 회원 정보가 없습니다.");
						}else { // null말고 제대로 반환하면
							System.out.println("회원님의 아이디는 "+id+"입니다.");
						}
						
					}else if(s==2) { // pw찾기
						System.out.println("===============================");
						System.out.println("         비밀번호 찾기 페이지");
						System.out.println("===============================");
						System.out.println("아이디 입력 : "); String id = scanner.next();
						System.out.println("전화번호 입력 : "); String contact = scanner.next();
						String pw=Controller.pwsearch(id, contact);
						if(pw==null) { // 리턴값이 null이면
							System.out.print("일치하는 회원 정보가 없습니다.");
						}else { // null말고 제대로 반환하면
							System.out.print("회원님의 비밀번호는 "+pw+"입니다.");
						}
					}
					
				} else {
					System.err.println("\n잘못된 접근\n");
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void game(String id) {
		try {
			while(true) {
				System.out.println("---------끝말잇기 게임---------");
				System.out.println("1. 시작 2. 내 점수보기 3.로그아웃");
				System.out.println("----------------------------");
				System.out.print(">>>>>: "); int ch = scanner.nextInt();
				
				if(ch == 1) {
						System.out.println("게임 시작");
						String firstword = Controller.randomfirstword();
						System.out.print("첫번째 글자 : " + firstword + "\n");
					while(true) {
							System.out.print("입력 > "); 	String word = scanner.next();
							boolean 결과 = Controller.gameStart(id, word);
							if(결과) {				
							}else {
								System.err.println("게임 종료");
								Controller.initialization(id);
								break;
							}
						}
					}
				else if(ch == 2) {
					System.out.println("---------점수 보기---------");
					Controller.seeScore(id);
				}
				else if(ch == 3) {break;}
				else System.out.println("올바른 숫자 입력");
			}
		}catch(Exception e) {}
	}

}
