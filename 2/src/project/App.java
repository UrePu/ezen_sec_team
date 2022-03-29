package project;

import java.util.Scanner;

public class App {//cs
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {//ms
		Controller.load();

		try {//ts
			while(true) {//ws
				//메뉴[ 1. 회원가입 2. 로그인 3. 랭킹보기 4. 아이디 찾기 5. 비밀번호 찾기 6. 종료]
				System.out.println(" ===================================");
				System.out.println(" \t\t\t\t끝말잇기 게임");
				System.out.println(" ===================================");
				System.out.println(" \t\t\t\t1. 회원가입");
				System.out.println(" \t\t\t\t2. 로그인");
				System.out.println(" \t\t\t\t3. 랭킹보기");
				System.out.println(" \t\t\t\t4. 아이디 찾기");
				System.out.println(" \t\t\t\t5. 비밀번호 찾기");
				System.out.println(" \t\t\t\t6. 종료");
				System.out.println(" ===================================");
				int ch = scanner.nextInt();
				//회원가입
				if(ch==1) {
					System.out.println(" ===================================");
					System.out.println(" \t\t\t\t1. 회원가입");
					System.out.println(" ===================================");
					System.out.println("ID는 12글자 이하 / PW는 8글자 이상 숫자, 영문, 특수문자 반드시 포함");
					System.out.println("Id :"); String id = scanner.next();
					System.out.println("Password :"); String pw = scanner.next();
					System.out.println("이름 :"); String name = scanner.next();
					System.out.println("전화번호 :"); String phone = scanner.next();
					
					if (Controller.id_valid(id) == 0) {
						System.err.println("\n아이디는 12글자 이하로 입력해주세요.\n");
					} else if (Controller.id_valid(id) == 1 && Controller.pw_valid(pw) == 0) {
						System.err.println("\n비밀번호는 8글자 이상 숫자, 영문, 특수문자를 반드시 포함해 주세요.");
					} else if (Controller.id_valid(id) == 1 && Controller.pw_valid(pw) == 1) {
						boolean result = Controller.duplication_test(id);
						if(result) {
						Controller.sign_up(id, pw, name, phone);
						System.out.println("\n회원가입 성공");
						}
						else System.out.println("이미 존재하는 아이디 입니다.");
					}
				}
				//로그인
				else if(ch==2) {
					System.out.println(" ===================================");
					System.out.println(" \t\t\t\t 로그인");
					System.out.println(" ===================================");
					System.out.print("ID : ");			String id = scanner.next();
					System.out.print("PW : ");			String pw = scanner.next();
					int result = Controller.login(id, pw);
					if (result == 1) {
						System.out.println("\n로그인 성공\n");
						System.out.println("1. 게임 시작 2. 로그아웃");
						int ch1 = scanner.nextInt();
						//게임시작
						if(ch1==1) {Controller.game(id);}
						else if(ch1==2) {
							System.out.println("로그아웃되었습니다.");
						}
						else System.out.println("잘못입력하였습니다.");
					}
					else if (result == 2) {System.err.println("\n비밀번호 오류\n");} 
					else if (result == 3) {System.err.println("\n아이디 오류\n");}
				}
				//랭킹보기
				else if(ch==3) {
					Controller.ranking();
				}
				
				//아이디 찾기
				else if(ch==4) {
					System.out.println("===============================");
					System.out.println(" \t\t\t\t4. 아이디 찾기");
					System.out.println("===============================");
					System.out.println("이름 입력 : "); String name = scanner.next();
					System.out.println("전화번호 입력 : "); String contact = scanner.next();
					String id=Controller.idsearch(name, contact);
					if(id==null) { // 리턴값이 null이면
						System.err.println("일치하는 회원 정보가 없습니다.");
					}else { // null말고 제대로 반환하면
						System.out.println("회원님의 아이디는 "+id+"입니다.");
					}
				}
				
				//비밀번호 찾기
				else if(ch==5) {		
					System.out.println("===============================");
					System.out.println(" \t\t\t\t5. 비밀번호 찾기");
					System.out.println("===============================");
					System.out.println("아이디 입력 : "); String id = scanner.next();
					System.out.println("전화번호 입력 : "); String contact = scanner.next();
					String pw=Controller.pwsearch(id, contact);
					if(pw==null) { // 리턴값이 null이면
						System.err.print("일치하는 회원 정보가 없습니다.");
					}
					else { // null말고 제대로 반환하면
						System.out.println("회원님의 비밀번호는 "+pw+"입니다.");}
				}
				//종료
				else if(ch==6) {
					System.exit(0);
				}
				else {
					System.err.println("잘못입력하였습니다.");
				}
			}//we
		}//te
		catch(Exception e) {scanner = new Scanner(System.in);}
	}//me
}//ce
