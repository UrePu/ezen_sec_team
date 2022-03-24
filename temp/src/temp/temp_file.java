package temp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class temp_file {
	public void save() { // 저장 s
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("D:/java/temp.txt");
			// String output = 파일에 적을 내용
			//fileOutputStream.write(output.getBytes()); // 바이트화 해서 기록
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	} // 저장 e
	
	public void load() { // 불러오기 s
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/temp.txt");
			byte[] bytes = new byte[1024]; // 바이트 배열 선언
			fileInputStream.read(bytes);
			String file = new String(bytes); // 파일내용 선언
			String[] list = file.split("\n"); // \n 기준으로 자르기
			for( String temp : list) {
		 		String[] memberList = temp.split("기준"); // "기준" 을 기준으로 자르기
//		 		Member member = new Member(memberList[0], memberList[1], memberList[2]); // 아이디, 비밀번호, 점수
		 					// 문자열 --> 정수형 변환 
		 					// 리스트 저장
		 		//ArrayList이름.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // 불러오기 e
}
