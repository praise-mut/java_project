package service.implementation;

import service.OtpServiceInterface;
import util.OtpGenerator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OtpServiceImpl extends UnicastRemoteObject implements OtpServiceInterface {

    private static final Map<String, String> otpStore = new ConcurrentHashMap<>();

    public OtpServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String generateAndSendOtp(String email) throws RemoteException {
        String otp = OtpGenerator.generateOtp();
        boolean sent = OtpGenerator.sendEmail(email, otp);
        if (sent) {
            otpStore.put(email, otp);
            return "OTP sent successfully";
        } else {
            return "Failed to send OTP";
        }
    }

    @Override
    public boolean validateOtp(String email, String otp) throws RemoteException {
        if (otpStore.containsKey(email) && otpStore.get(email).equals(otp)) {
            otpStore.remove(email); // Invalidate OTP after use
            return true;
        }
        return false;
    }
}
