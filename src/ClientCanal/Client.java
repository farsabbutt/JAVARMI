package ClientCanal;

import ServerRiver.ServerIF;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Qosmio on 10/1/2017.
 */
public class Client extends UnicastRemoteObject implements ClientIF, Runnable{
    private String name = null;
    private ServerIF Server;
  

    protected Client(ServerIF Server) throws RemoteException {
      
          
          
         
         
        this.Server = Server;
        Server.registerClient(this);
    }

    @Override
    public void retrieveMessage(String message, boolean FlagStatus) throws RemoteException {
        System.out.println("Added: " + message);
        if(FlagStatus)
            System.out.println("River Level Exceeded");
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String message;
        int quantity = 0;
        while(true){
//            message = scanner.nextLine();
//            try {
//                Server.broadCastMessage(name + ": " + message);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
            
            
            
            quantity = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            
          
            
            try {
              
                Server.addWater(quantity);
                TimeUnit.SECONDS.sleep(1);
            } catch (RemoteException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
