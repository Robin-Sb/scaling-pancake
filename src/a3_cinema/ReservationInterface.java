package a3_cinema;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReservationInterface extends Remote {
	public abstract Boolean makeReservations(int index, String name) throws RemoteException;
	public abstract String[] getReservations() throws RemoteException;
	public static final String LOOKUPNAME = "RMI-ReservationService";

}