package a2_time_service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService {
	public static void serveSocket() throws IOException {
		ServerSocket timeService = new ServerSocket(8085);
		
		timeService.setSoTimeout(20000);
		try {
			while (true) {
				System.out.println("Open for a new connection.");
				Socket clientSocket = timeService.accept();
				new Thread(new TimeServiceImpl(clientSocket)).start();
			}

		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
				 timeService.close();
				 System.out.println("Timeservice disconnected.");
		}
	}
}
