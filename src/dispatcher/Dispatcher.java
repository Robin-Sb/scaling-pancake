package dispatcher;

public class Dispatcher extends Thread {
	public static int[] execute(Function f, int n) {
		for (int i = 0; i < n; n++) {
			Dispatcher dispatcher = new Dispatcher();
			dispatcher.start();
		}
		return null;
	}
	
	public void run () {
		
	}
}
