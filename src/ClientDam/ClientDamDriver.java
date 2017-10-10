/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientDam;

import ClientCanal.Client;
import ServerRiver.ServerIF;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Qosmio
 */
public class ClientDamDriver {
    public static void main(String[] args) throws MalformedURLException,RemoteException,NotBoundException{
        String serverURL = "rmi://localhost/MYSERVER";
        ServerIF server = (ServerIF) Naming.lookup(serverURL);
        new Thread(new Dam(server)).start();
    }
}
