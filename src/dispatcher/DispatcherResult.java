package dispatcher;

public class DispatcherResult {
	
	public int[] results;
	
	public synchronized int[] getResult() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public synchronized void putResult() {
	}
	
	
}
