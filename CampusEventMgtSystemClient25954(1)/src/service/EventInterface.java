
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Event;


public interface EventInterface extends Remote{
        
    public String addEvent(Event event) throws RemoteException;
    public String updateEvent(Event event) throws RemoteException;
    public String deleteEvent(Event event) throws RemoteException;
    public Event getEventById(Event event) throws RemoteException;
    public List<Event> getAllUsers() throws RemoteException;
}
