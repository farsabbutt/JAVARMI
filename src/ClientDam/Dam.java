/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientDam;

import ClientCanal.ClientIF;
import ServerRiver.ServerIF;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Qosmio
 */
public class Dam extends UnicastRemoteObject implements Runnable {
    ServerIF server;
    protected Dam(ServerIF server) throws RemoteException{
        this.server = server;
    }

    @Override
    public void run() {
       while(true){
           try {
               if(server.getQuantity() > 100){
                   int quantity = ThreadLocalRandom.current().nextInt(30, 50 + 1);
                   openDam(quantity);
               }
           } catch (RemoteException ex) {
               Logger.getLogger(Dam.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
       }
    }

    public void openDam(int quantity) throws RemoteException {
       
        this.server.removeQuantity(quantity);
        System.out.println("Removed Quantity: " + quantity);
    }
}
