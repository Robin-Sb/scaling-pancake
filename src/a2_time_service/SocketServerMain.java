package a2_time_service;

import java.io.IOException;

public class SocketServerMain {
	
	public static void main(String[] args) {
		System.out.println("Starting TimeService");
		try {
			while(true)
			{
				TimeService.serveSocket();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
