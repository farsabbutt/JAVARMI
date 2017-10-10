package ServerRiver;

import ClientCanal.ClientIF;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Qosmio on 10/1/2017.
 */
public interface ServerIF extends Remote {
void registerClient(ClientIF client) throws RemoteException;
void broadCastMessage(String message) throws RemoteException;
void addWater(int quantity)throws RemoteException;
int getQuantity() throws RemoteException;
void removeQuantity(int quantity) throws RemoteException;
}
