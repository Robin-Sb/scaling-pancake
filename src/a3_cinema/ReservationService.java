package a3_cinema;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ReservationService {
	private static final String HOST = "localhost";
	private static final String SERVICE_NAME = "RMI-ReservationService";
	private static final String RMI_SERVICE = "rmi://"+HOST+"/"+SERVICE_NAME;

	public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
		System.setProperty("java.rmi.server.hostname", HOST);
		Registry reg = LocateRegistry.createRegistry(1099);
		Reservation_Impl reservator = new Reservation_Impl();
		// reg.bind(RMI_SERVICE, reservator);
		Naming.rebind(RMI_SERVICE, reservator);
		System.out.println("RMI started");
	}

}
