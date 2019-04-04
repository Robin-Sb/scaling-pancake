package a2_time_service_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TimeServiceClient {
	
	public static void serveClient() throws IOException {
	String ip = InetAddress.getLocalHost().getHostAddress();
	System.out.println(ip);
	Socket clientSocket = new Socket(ip, 8085);
	System.out.println("Starting Client Socket");
	
    BufferedWriter out = new BufferedWriter(
    	new OutputStreamWriter(clientSocket.getOutputStream()));
    BufferedReader in = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
	System.out.println(in.readLine());
	Scanner scn = new Scanner(System.in);
	while (true) {
		String input = scn.nextLine();
		out.write(input);
		out.newLine();
		out.flush();
		String recv = in.readLine();
		if(recv.equals("disconnected")) {
			out.flush();
			scn.close();
			in.close();
			out.close();
			break;
		}
		System.out.println(recv);
	}

	System.out.println("Time Service was disconnected by responder because of invalid input.");
	clientSocket.close();
	}
}
