package dispatcher;

public class DispatcherMain {
	public static void main(String[] args) {
		// Dispatcher dispatcher = new Dispatcher();
		CustomFunction function = new CustomFunction();
		Dispatcher.execute(function, 10);
		
		DispatcherResult result = new DispatcherResult();
		result.getResult();
	}
}
