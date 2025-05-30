
package service.implementation;

import dao.ParticipantDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Participant;
import service.ParticipantInterface;


public class ParticipantImpl extends UnicastRemoteObject implements ParticipantInterface{
    
    public ParticipantImpl() throws RemoteException{
        super();
    }
    ParticipantDao dao = new ParticipantDao();

    @Override
    public String addParticipant(Participant participant) throws RemoteException {
        return dao.addParticipant(participant);
    }

    @Override
    public String updateParticipant(Participant participant) throws RemoteException {
        return dao.updateParticipant(participant);
    }

    @Override
    public String deleteParticipant(Participant participant) throws RemoteException {
        return dao.deleteParticipant(participant);
    }

    @Override
    public Participant getParticipantById(Participant participant) throws RemoteException {
        return dao.getParticipantById(participant);
    }

    @Override
    public List<Participant> getAllParticipants() throws RemoteException {
        return dao.getAllParticipants();
    }
    
    
}
