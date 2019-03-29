package dispatcher;

public class DispatcherMain {
	public static void main(String[] args) {
		// Dispatcher dispatcher = new Dispatcher();
		CustomFunction function = new CustomFunction();
		Integer[] results = Dispatcher.execute(function, 10);
		
		int addedResult = 0;
		for (int i = 0; i < results.length; i++) {
			addedResult += results[i];
		}
		System.out.println(addedResult);
	}
}
