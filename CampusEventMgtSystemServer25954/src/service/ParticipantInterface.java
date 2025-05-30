
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Participant;


public interface ParticipantInterface extends Remote{
    public String addParticipant(Participant participant) throws RemoteException;
    public String updateParticipant(Participant participant) throws RemoteException;
    public String deleteParticipant(Participant participant) throws RemoteException;
    public Participant getParticipantById(Participant participant) throws RemoteException;
    public List<Participant> getAllParticipants() throws RemoteException;
}
