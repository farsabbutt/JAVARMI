package ServerRiver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by Qosmio on 10/1/2017.
 */
public class ServerDriver {


    public static void main(String[] args) throws RemoteException,MalformedURLException{
        Naming.rebind("MYSERVER", new Server());
    }

}
