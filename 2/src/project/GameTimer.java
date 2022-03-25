package JHS;

public class GameTimer extends Thread {

	@Override
	public void run() {
		for(int i=60; i>=1; i--){
			if(App.inputCheck==true){
				return;
			}
			System.out.println(i);
			try {Thread.sleep(1000);} 
			catch (Exception e) {}
		}
		System.out.println("시간이 초과되어 당신이 졌습니다.");
		System.exit(0);
	}
}
