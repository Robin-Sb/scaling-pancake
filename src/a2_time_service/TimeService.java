package a2_time_service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService {
	public static void serveSocket() throws IOException {
		ServerSocket timeService = new ServerSocket(75);
		
		try {
			System.out.println("Starting TimeService");
			Socket clientSocket = timeService.accept();
			System.out.println("... accepted");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(clientSocket.getOutputStream()));
			out.write("time service");
			out.newLine();
			out.flush();
			String inputLine;
			boolean closeConnection = false;
			while (!closeConnection) {
				boolean isSet = false;
				inputLine = in.readLine();
				if (!inputLine.equals("date") && !inputLine.equals("time") ) {
					closeConnection = true;
					out.write("Disconnected");
					out.newLine();
					out.flush();
					break;
				}
				System.out.println(inputLine);
				if (inputLine.equals("date")) {
					String date = Clock.getDate();
					out.write(date);
					System.out.println((date));
				}
				if (inputLine.equals("time")) {
					out.write(Clock.getTime());
				}
				out.newLine();
				out.flush();
			} 
			timeService.close();
			System.out.println("Timeservice disconnected.");

		} catch (Exception e) {
			e.printStackTrace();	}
	}
}
