package project;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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
						boolean result = Controller.duplication_text(id);
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
					} else if (result == 2) {
						System.err.println("\n비밀번호 오류\n");
					} else if (result == 3) {
						System.err.println("\n아이디 오류\n");
					}
					
				} else if (ch == 3) {
					
				} else {
					System.err.println("\n잘못된 접근\n");
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
