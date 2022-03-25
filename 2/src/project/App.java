package project;

import java.util.Scanner;


public class App {
	
	public static boolean inputCheck = false;
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			
			while(true) {
				System.out.println("===============================");
				System.out.println("              �����ձ�");
				System.out.println("===============================");
				System.out.println("1. ȸ������ 2. �α��� 3. ID/PW ã��\n");
				System.out.print("���� > "); 		int ch = scanner.nextInt();
				
				if (ch == 1) {
					System.out.println("===============================");
					System.out.println("              ȸ������");
					System.out.println("===============================");
					System.out.println("ID�� 12���� ���� / PW�� 8���� �̻� ����, ����, Ư������ �ݵ�� ����");
					System.out.print("ID �Է� : ");				String id = scanner.next();
					System.out.print("PW �Է� : ");				String pw = scanner.next();
					System.out.print("�̸� �Է� : ");				String name = scanner.next();
					System.out.print("��ȭ��ȣ �Է� : ");			String contact = scanner.next();
					
					if (Controller.id_valid(id) == 0) {
						System.err.println("\n���̵�� 12���� ���Ϸ� �Է����ּ���.\n");
					} else if (Controller.id_valid(id) == 1 && Controller.pw_valid(pw) == 0) {
						System.err.println("\n��й�ȣ�� 8���� �̻� ����, ����, Ư�����ڸ� �ݵ�� ������ �ּ���.");
					} else if (Controller.id_valid(id) == 1 && Controller.pw_valid(pw) == 1) {
						boolean result = Controller.duplication_test(id);
						if (result) {
							Controller.sign_up(id, pw, name, contact);
							System.out.println("\nȸ������ ����");
						} else {
							System.err.println("�̹� �����ϴ� ���̵��Դϴ�.");
						}
					}
				} else if (ch == 2){
					System.out.println("===============================");
					System.out.println("              �α���");
					System.out.println("===============================");
					System.out.print("ID : ");			String id = scanner.next();
					System.out.print("PW : ");			String pw = scanner.next();
					int result = Controller.login(id, pw);
					if (result == 1) {
						System.out.println("\n�α��� ����\n");
						System.out.println("\n1. ���ӽ��� 2. �α׾ƿ�");
						game(id);
					} else if (result == 2) {
						System.err.println("\n��й�ȣ ����\n");
					} else if (result == 3) {
						System.err.println("\n���̵� ����\n");
					}
				} else if (ch == 3) {
					System.out.println("1. IDã�� 2. PWã��"); int s = scanner.nextInt();
					if(s==1) { // idã��
						System.out.println("===============================");
						System.out.println("           IDã�� ������");
						System.out.println("===============================");
						System.out.println("�̸� �Է� : "); String name = scanner.next();
						System.out.println("��ȭ��ȣ �Է� : "); String contact = scanner.next();
						String id=Controller.idsearch(name, contact);
						if(id==null) { // ���ϰ��� null�̸�
							System.out.println("��ġ�ϴ� ȸ�� ������ �����ϴ�.");
						}else { // null���� ����� ��ȯ�ϸ�
							System.out.println("ȸ������ ���̵�� "+id+"�Դϴ�.");
						}
						
					}else if(s==2) { // pwã��
						System.out.println("===============================");
						System.out.println("         ��й�ȣ ã�� ������");
						System.out.println("===============================");
						System.out.println("���̵� �Է� : "); String id = scanner.next();
						System.out.println("��ȭ��ȣ �Է� : "); String contact = scanner.next();
						String pw=Controller.pwsearch(id, contact);
						if(pw==null) { // ���ϰ��� null�̸�
							System.out.print("��ġ�ϴ� ȸ�� ������ �����ϴ�.");
						}else { // null���� ����� ��ȯ�ϸ�
							System.out.print("ȸ������ ��й�ȣ�� "+pw+"�Դϴ�.");
						}
					}
					
				} else {
					System.err.println("\n�߸��� ����\n");
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void game(String id) {
		try {
			while(true) {
				System.out.println("---------�����ձ� ����---------");
				System.out.println("1. ���� 2. �� �������� 3.�α׾ƿ�");
				System.out.println("----------------------------");
				System.out.print(">>>>>: "); int ch = scanner.nextInt();
				
				if(ch == 1) {
						System.out.println("���� ����");
						String firstword = Controller.randomfirstword();
						System.out.print("ù��° ���� : " + firstword + "\n");
					while(true) {
							System.out.print("�Է� > "); 	String word = scanner.next();
							boolean ��� = Controller.gameStart(id, word);
							if(���) {				
							}else {
								System.err.println("���� ����");
								Controller.initialization(id);
								break;
							}
						}
					}
				else if(ch == 2) {
					System.out.println("---------���� ����---------");
					Controller.seeScore(id);
				}
				else if(ch == 3) {break;}
				else System.out.println("�ùٸ� ���� �Է�");
			}
		}catch(Exception e) {}
	}

}
