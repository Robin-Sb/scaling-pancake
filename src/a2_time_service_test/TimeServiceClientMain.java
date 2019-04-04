package a2_time_service_test;

import java.io.IOException;

public class TimeServiceClientMain {

	public static void main(String[] args) {
		try {
			TimeServiceClient.serveClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
