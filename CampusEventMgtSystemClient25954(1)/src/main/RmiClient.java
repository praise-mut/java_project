package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.EventInterface;
import service.ParticipantInterface;
import service.UserInterface;
import service.OtpServiceInterface;

public class RmiClient {

    private static UserInterface userService;
    private static EventInterface eventService;
    private static ParticipantInterface participantService;
    private static OtpServiceInterface otpService;

    private static final String RMI_HOST = "127.0.0.1";
    private static final int RMI_PORT = 6000;

    static {
        connect();
    }

    private static void connect() {
        try {
            Registry registry = LocateRegistry.getRegistry(RMI_HOST, RMI_PORT);

            userService = (UserInterface) registry.lookup("User");
            eventService = (EventInterface) registry.lookup("Event");
            participantService = (ParticipantInterface) registry.lookup("Participant");
            otpService = (OtpServiceInterface) registry.lookup("OtpService");

            System.out.println("RMI services (User, Event, Participant, OtpService) looked up successfully.");

        } catch (NotBoundException nbe) {
            System.err.println("RMI Lookup Error: Service not bound. Check server and lookup names (User, Event, Participant, OtpService). Host: " + RMI_HOST + ", Port: " + RMI_PORT);
            nbe.printStackTrace();
        } catch (RemoteException re) {
            System.err.println("RMI Connection Error: Could not connect to RMI registry at " + RMI_HOST + ":" + RMI_PORT);
            re.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error during RMI client initialization:");
            e.printStackTrace();
        }
    }

    public static void reconnect() {
        connect();
    }

    public static UserInterface getUserService() {
        if (userService == null) {
            System.err.println("UserInterface RMI service is null. Check RMI server connection and logs.");
        }
        return userService;
    }

    public static EventInterface getEventService() {
        if (eventService == null) {
            System.err.println("EventInterface RMI service is null. Check RMI server connection and logs.");
        }
        return eventService;
    }

    public static ParticipantInterface getParticipantService() {
        if (participantService == null) {
            System.err.println("ParticipantInterface RMI service is null. Check RMI server connection and logs.");
        }
        return participantService;
    }

    public static OtpServiceInterface getOtpService() {
        if (otpService == null) {
            System.err.println("OtpServiceInterface RMI service is null. Check RMI server connection and logs.");
        }
        return otpService;
    }

    public static void main(String[] args) {
        System.out.println("Attempting to connect to RMI services via RmiClient...");

        UserInterface us = getUserService();
        EventInterface es = getEventService();
        ParticipantInterface ps = getParticipantService();
        OtpServiceInterface os = getOtpService();

        if (us != null) {
            System.out.println("RmiClient: UserInterface obtained successfully.");
        } else {
            System.err.println("RmiClient: UserInterface is null. RMI lookup likely failed.");
        }

        if (es != null) {
            System.out.println("RmiClient: EventInterface obtained successfully.");
        } else {
            System.err.println("RmiClient: EventInterface is null. RMI lookup likely failed.");
        }

        if (ps != null) {
            System.out.println("RmiClient: ParticipantInterface obtained successfully.");
        } else {
            System.err.println("RmiClient: ParticipantInterface is null. RMI lookup likely failed.");
        }

        if (os != null) {
            System.out.println("RmiClient: OtpServiceInterface obtained successfully.");
        } else {
            System.err.println("RmiClient: OtpServiceInterface is null. RMI lookup likely failed.");
        }
    }
}
