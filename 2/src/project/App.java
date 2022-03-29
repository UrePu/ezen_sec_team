package project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class App {
	
	public static boolean inputCheck = false;
	
	static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) {
		Controller.load();
		
		try {
			
			while(true) {
				System.out.println("===============================");
				System.out.println("              끝말잇기");
				System.out.println("===============================");
				System.out.println("1. 회원가입 2. 로그인 3. ID찾기 4. 비밀번호 찾기 5. 랭킹\n");
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
						game(id);
					} else if (result == 2) {
						System.err.println("\n비밀번호 오류\n");
					} else if (result == 3) {
						System.err.println("\n아이디 오류\n");
					}
				}
					else if(ch==3) { // id찾기
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
						
					}else if(ch==4) { // pw찾기
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
					
					} // pw찾기 e
					else if(ch == 5) {Controller.ranking();} // 랭킹보기
					else {
					System.err.println("\n잘못된 접근\n");
				}
				
		}// while end
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void game (String id) throws InterruptedException {
		
		try {
			while(true) {
				System.out.println("---------끝말잇기 게임---------");
				System.out.println("1.시작 2.내 점수보기 3.로그아웃");
				System.out.println("----------------------------");
				System.out.print(">>>>>: "); int ch = scanner.nextInt();
				
				boolean 결과 = false;
				if(ch == 1) {
					System.out.println("난이도를 선택하세요");
					System.out.println("1.쉬움 2.보통 3.어려움"); int level = scanner.nextInt();
					System.out.println("게임 시작");
					String firstword = Controller.randomfirstword();
					System.out.print("첫번째 글자 : " + firstword + "\n");
					long timelimit = 20;
					while(true) {
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss",Locale.KOREA);
						Date date = new Date();
						String starttime = dateFormat.format(date);
						System.out.println("시작시간 : " + starttime);
						Date d1 = dateFormat.parse(starttime);
						System.out.print("입력 > "); 	String word = scanner.next();
						Date date1 = new Date();
						String endtime = dateFormat.format(date1);
						Date d2 = dateFormat.parse(endtime);
			
						long diff = d2.getTime() - d1.getTime();
						long sec = diff / 1000;

						if (sec < timelimit) { // 시간제한에 걸리지 않았을 시(통과시)
							결과 = Controller.gameStart(id, word);
							if (timelimit > 4) { //시간제한이 4초보다 많을 때에
								if(level==1) {timelimit-=1;} // 쉬움 난이도에서 1초씩 감소
								if(level==2) {timelimit-=2;} // 보통 난이도에서 2초씩 감소
								if(level==3) {timelimit-=4;} // 어려움 난이도에서 4초씩 감소
							}
							System.out.println("시간제한 : " + timelimit);
						} else {
							System.err.println("시간 초과");
							결과 = false;
						}
						if(!결과) {	
							System.err.println("게임 종료");
							Controller.initialization(id);
							break;
						} 
					}

				}
				else if(ch == 2) {
					System.out.println("---------내 점수 보기---------");
					System.out.print("내 점수 : "); Controller.seeScore(id);
				}
				else if(ch == 3) {break;}
				
				else System.out.println("올바른 숫자 입력");
			}
		}catch(Exception e) {}
	}

}
