package project;

public class GameTimer extends Thread {
	
	
	private boolean stop;
	


	public void setStop(boolean stop) {
		this.stop = stop;
	}



	@Override
	public void run() {
		int i = 60;
		
		while (!stop) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i--;
		}
	}
		
}