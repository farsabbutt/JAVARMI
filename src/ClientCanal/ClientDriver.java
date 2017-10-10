package ClientCanal;

import ServerRiver.ServerIF;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Qosmio on 10/1/2017.
 */
public class ClientDriver {


    public static void main(String[] args) throws MalformedURLException,RemoteException,NotBoundException{
        String serverURL = "rmi://localhost/MYSERVER";
        ServerIF server = (ServerIF) Naming.lookup(serverURL);
        new Thread(new Client(server)).start();
    }


}
