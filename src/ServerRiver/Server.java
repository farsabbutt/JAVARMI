package ServerRiver;

import ClientCanal.Client;
import ClientCanal.ClientIF;
import ClientDam.Dam;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by Qosmio on 10/1/2017.
 */
public class Server extends UnicastRemoteObject implements ServerIF {

    private static final long serialVersionID = 1L;
    private ArrayList<ClientIF> clients;
    private Dam dam;
    private boolean FlagStatus = false;
    private int Quantity = 0;
    private static final int TotalQuantity = 100;
    

    protected Server() throws RemoteException {
        clients = new ArrayList<ClientIF>();

    }


    @Override
    public synchronized void registerClient(ClientIF client) throws RemoteException {
            this.clients.add(client);
    }

    @Override
    public synchronized void broadCastMessage(String message) throws RemoteException {

        int i = 0;
        while(i<clients.size()){
            clients.get(i++).retrieveMessage(message, FlagStatus);
        }

    }
    
    
    public synchronized void addWater(int quantity) throws RemoteException{
    
        Quantity = Quantity + quantity;
        System.out.println("Total Quantity: " + Quantity);
        if(Quantity > TotalQuantity){
            FlagStatus = true;
            System.out.println("River Level Exceeded!");
            System.out.println("Dam opened to release water!");
        }
        
        int i = 0;
        while(i<clients.size()){
            clients.get(i++).retrieveMessage(Integer.toString(quantity), FlagStatus);
           
        }
        
    
    }

    @Override
    public int getQuantity() throws RemoteException {
        return this.Quantity;
    }

    @Override
    public void removeQuantity(int quantity) throws RemoteException {
        this.Quantity = this.Quantity - quantity;
        // reset flag
        if(this.Quantity < TotalQuantity){
        FlagStatus = false;
        }
        
    }
}
