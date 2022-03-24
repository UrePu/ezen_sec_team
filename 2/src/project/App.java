package project;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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
						boolean result = Controller.duplication_text(id);
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
					} else if (result == 2) {
						System.err.println("\n��й�ȣ ����\n");
					} else if (result == 3) {
						System.err.println("\n���̵� ����\n");
					}
					
				} else if (ch == 3) {
					
				} else {
					System.err.println("\n�߸��� ����\n");
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
