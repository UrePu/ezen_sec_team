package temp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class temp_file {
	public void save() { // ���� s
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("D:/java/temp.txt");
			// String output = ���Ͽ� ���� ����
			//fileOutputStream.write(output.getBytes()); // ����Ʈȭ �ؼ� ���
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	} // ���� e
	
	public void load() { // �ҷ����� s
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/temp.txt");
			byte[] bytes = new byte[1024]; // ����Ʈ �迭 ����
			fileInputStream.read(bytes);
			String file = new String(bytes); // ���ϳ��� ����
			String[] list = file.split("\n"); // \n �������� �ڸ���
			for( String temp : list) {
		 		String[] memberList = temp.split("����"); // "����" �� �������� �ڸ���
//		 		Member member = new Member(memberList[0], memberList[1], memberList[2]); // ���̵�, ��й�ȣ, ����
		 					// ���ڿ� --> ������ ��ȯ 
		 					// ����Ʈ ����
		 		//ArrayList�̸�.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // �ҷ����� e
}
