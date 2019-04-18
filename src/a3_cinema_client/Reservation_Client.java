package a3_cinema_client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import a3_cinema.ReservationInterface;

public class Reservation_Client {
	private static final String HOST = "localhost";
	private static final String SERVICE_NAME = ReservationInterface.LOOKUPNAME;
	private static final String RMI_SERVICE = "rmi://"+HOST+"/"+SERVICE_NAME;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		ReservationInterface reser = (ReservationInterface) Naming.lookup(RMI_SERVICE);
		int index;
		try {
			index = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Not a valid number");
			return;
		}
		
		boolean couldReservate = reser.makeReservations(index, args[1]);
		System.out.println(couldReservate);
		String[] out = reser.getReservations();
		for (int i = 0; i < out.length; i++) {
			System.out.println(out[i]);
		}
	}
}
