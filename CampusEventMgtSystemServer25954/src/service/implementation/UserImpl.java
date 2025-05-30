
package service.implementation;

import dao.UserDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.User;
import service.UserInterface;


public class UserImpl extends UnicastRemoteObject implements UserInterface{

    public UserImpl() throws RemoteException{
        super();
    }
    UserDao dao = new UserDao();

    @Override
    public String addUser(User user) throws RemoteException {
        return dao.addUser(user);
    }

    @Override
    public String updateUser(User user) throws RemoteException {
        return dao.updateUser(user);
    }

    @Override
    public String deleteUser(User user) throws RemoteException {
        return dao.deleteUser(user);
    }

    @Override
    public User getUserById(User user) throws RemoteException {
        return dao.getUserById(user);
    }

    @Override
    public List<User> getAllUsers() throws RemoteException {
        return dao.getAllUsers();
    }

    @Override
    
    public User authenticate(String username, String password) throws RemoteException {
        try {
            return dao.authenticate(username, password);
        } catch (Exception e) {
            throw new RemoteException("Authentication failed", e);
        }
    }

    
    
}
