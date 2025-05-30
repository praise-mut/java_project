
package service.implementation;

import dao.EventDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Event;
import service.EventInterface;


public class EventImpl extends UnicastRemoteObject implements EventInterface{
    
    public EventImpl() throws RemoteException {
        super();
    }
    EventDao dao = new EventDao();
    

    @Override
    public String addEvent(Event event) throws RemoteException {
        return dao.addEvent(event);
    }

    @Override
    public String updateEvent(Event event) throws RemoteException {
        return dao.updateEvent(event);
    }

    @Override
    public String deleteEvent(Event event) throws RemoteException {
        return dao.deleteEvent(event);
    }

    @Override
    public Event getEventById(Event event) throws RemoteException {
        return dao.getEventById(event);
    }

    @Override
    public List<Event> getAllUsers() throws RemoteException {
        return dao.getAllEvents();
    }
    
}
