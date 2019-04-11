package a2_time_service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TimeServiceImpl implements Runnable {
	
	Socket _socket = new Socket();
	
	TimeServiceImpl (Socket _socket) {
		this._socket = _socket;
	}

	public void run() {
		try {
			serveInThread();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void serveInThread() throws IOException {
		System.out.println("Client " + this._socket.getInetAddress() + " accepted");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(this._socket.getInputStream()));
		BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(this._socket.getOutputStream()));
		out.write("time service");
		out.newLine();
		out.flush();
		String inputLine;
		boolean closeConnection = false;
		while (!closeConnection) {
			boolean isSet = false;
			inputLine = in.readLine();
			
			if (inputLine == null) {
				closeConnection = true;
				break;
			}
			if (!inputLine.equals("date") && !inputLine.equals("time") ) {
				closeConnection = true;
				out.write("disconnected");
				out.newLine();
				out.flush();
				break;
			}
			System.out.println("Received input: " + inputLine);
			if (inputLine.equals("date")) {
				String date = Clock.getDate();
				out.write(date);
			}
			if (inputLine.equals("time")) {
				out.write(Clock.getTime());
			}
			out.newLine();
			out.flush();
		} 

	};
}
