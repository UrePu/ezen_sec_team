package project;

public class GameTimer extends Thread {
	
	
//	private boolean stop;
//	
//
//
//	public void setStop(boolean stop) {
//		this.stop = stop;
//	}



	@Override
	public void run() {
		
//		
//		while (!stop) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			i--;
//		}
		
		for (int i = 60; i >= 1; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		}
	}
		
}