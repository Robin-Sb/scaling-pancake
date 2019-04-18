package a3_cinema;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Reservation_Impl extends UnicastRemoteObject implements ReservationInterface {
	
	private static final long serialVersionUID = 1L;
	private String[] seats = new String[50];
	
	public Reservation_Impl() throws RemoteException {}
	
	@Override
	public synchronized Boolean makeReservations(int index, String name) {
		boolean couldReservate = false;
		if (seats[index] == null) {
			seats[index] = name;
			couldReservate = true;
		}
		return couldReservate;
	}

	@Override
	public synchronized String[] getReservations() {
		return seats;
	}
	
}
