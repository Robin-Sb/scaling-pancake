package dispatcher;

public class Dispatcher implements Runnable {
	
	public Dispatcher(CustomFunction f, DispatcherResult result, int x, int n) {
		this.result = result;
		this.x = x;
		this.f = f;
		this.n = n;
	}
	
	private CustomFunction f;
	private DispatcherResult result;
	private int x;
	private int n;
		
	public static Integer[] execute(CustomFunction f, int n) {
		DispatcherResult result = new DispatcherResult();
		for (int i = 0; i < n; i++) {
			new Thread( new Dispatcher(f, result, i, n) ).start();
		}
		return result.getResult();
	}
	
	public void run () {
		int result = this.f.function(x);
		this.result.putResult(result, this.n);
	}
}
