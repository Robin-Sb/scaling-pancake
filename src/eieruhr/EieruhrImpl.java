package eieruhr;

import java.util.Date;

public class EieruhrImpl implements Runnable {
	public int milliSeconds;
	public String commandText;
	
	public EieruhrImpl(int milliSeconds, String commandText) {
		this.milliSeconds = milliSeconds;
		this.commandText = commandText;
	}
	
	public void entry () {
		new Thread (new EieruhrImpl(this.milliSeconds, this.commandText)).start();
		this.milliSeconds -= 1000;
		while (this.milliSeconds > 0) {
			schlafen(1000);
			System.out.println(this.milliSeconds / 1000);
			this.milliSeconds -= 1000;
		}
	}
	
	public void eieruhr () {
		schlafen(this.milliSeconds);
		System.out.println(this.commandText);
	}
	
	public void run () {
		eieruhr();
	}
	
	public static void schlafen(int m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException t) {
			System.out.println(t);
		}
	}
}
