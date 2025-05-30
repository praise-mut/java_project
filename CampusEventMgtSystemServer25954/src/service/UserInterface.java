
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.User;


public interface UserInterface extends Remote{
    public String addUser(User user) throws RemoteException;
    public String updateUser(User user) throws RemoteException;
    public String deleteUser(User user) throws RemoteException;
    public User getUserById(User user) throws RemoteException;
    public List<User> getAllUsers() throws RemoteException;
    public User authenticate(String username, String password) throws RemoteException;
}
