package eieruhr;

public class EieruhrImpl extends Thread {
	int milliSeconds;
	String commandText;
	
	public EieruhrImpl(int milliSeconds, String commandText) {
		this.milliSeconds = milliSeconds;
		this.commandText = commandText;
	}
	
	public static void eieruhr (int milliSeconds, String commandText) {
		schlafen(milliSeconds);
		System.out.println(commandText);
	}
	
	public void run () {
		eieruhr(milliSeconds, commandText);
	}
	
	public static void schlafen(int m) {
		try {
			Thread.sleep(1000*m);
		} catch (InterruptedException t) {
			System.out.println(t);
		}
	}

}
