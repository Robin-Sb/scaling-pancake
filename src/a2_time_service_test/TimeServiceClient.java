package a2_time_service_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TimeServiceClient {
	
	public static void serveClient() throws IOException {
	Socket clientSocket = new Socket();
	System.out.println("Starting Client Socket");
	
    BufferedWriter out = new BufferedWriter(
    	new OutputStreamWriter(clientSocket.getOutputStream()));
    BufferedReader in = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
	System.out.println(in.readLine());
	Scanner scn = new Scanner(System.in);
	while (true) {
		String input = scn.nextLine();
		System.out.println(input);
		if (input.equals("disconnect")) {
			out.flush();
			scn.close();
			in.close();
			out.close();
			break;
		} else {
			out.write(input);
			out.newLine();
			out.flush();
			String recv = in.readLine();
			System.out.println(recv);
		}
	} // end while

	System.out.println("Disconnected Time Service");
	clientSocket.close();
	}
}
