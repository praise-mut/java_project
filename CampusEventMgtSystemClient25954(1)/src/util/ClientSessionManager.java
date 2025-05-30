package util;

import model.User;

public class ClientSessionManager {

    private static User loggedInUser;

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void clearSession() {
        loggedInUser = null;
    }

    public static boolean isAdmin() {
        return loggedInUser != null && "ADMIN".equalsIgnoreCase(loggedInUser.getRole());
    }

    public static boolean isUser() {
        return loggedInUser != null && "USER".equalsIgnoreCase(loggedInUser.getRole());
    }
} 
