package ClientCanal;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Qosmio on 10/1/2017.
 */
public interface ClientIF extends Remote {

    void retrieveMessage(String message, boolean FlagStatus) throws RemoteException;

}
