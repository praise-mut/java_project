
package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.implementation.*;


public class Server {
    private EventImpl evImpl;
    private ParticipantImpl partImpl;
    private UserImpl userImpl;

    public Server() throws RemoteException{
        this.evImpl = new EventImpl();
        this.partImpl = new ParticipantImpl();
        this.userImpl = new UserImpl();
    }
    
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            
            Registry registry = LocateRegistry.createRegistry(6000);
            registry.rebind("Event", new Server().evImpl);
            registry.rebind("Participant", new Server().partImpl);
            registry.rebind("User", new Server().userImpl);
            registry.rebind("OtpService", new OtpServiceImpl());
            System.out.println("Server is running on 6000");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
