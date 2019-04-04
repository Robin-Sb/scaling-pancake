package dispatcher;

import java.util.ArrayList;

public class DispatcherResult {
	
	public ArrayList<Integer> results = new ArrayList<Integer>();
	public int length;
	
	public synchronized Integer[] getResult() {
		try {
			if (results.size() == length) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return results.toArray(new Integer[results.size()]);
	}
	
	public synchronized void putResult(int result, int n) {
		length = n;
		results.add(result);
		if (results.size() == n)
		{
			notify();
		}
	}
}
