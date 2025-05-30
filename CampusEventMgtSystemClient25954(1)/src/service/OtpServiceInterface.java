package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OtpServiceInterface extends Remote {
    String generateAndSendOtp(String email) throws RemoteException;
    boolean validateOtp(String email, String otp) throws RemoteException;
}
