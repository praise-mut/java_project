package util;

public class ValidatorUtil {

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 3;
    }

    public static boolean isValidUsername(String username) {
        return username != null && username.length() >= 3;
    }

    public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z\\s]{2,}");
    }

    public static boolean isValidRole(String role) {
        return role != null && (role.equalsIgnoreCase("USER") || role.equalsIgnoreCase("ADMIN"));
    }

    public static boolean isValidStatus(String status) {
        return status != null && (status.equalsIgnoreCase("REGISTERED") || status.equalsIgnoreCase("PENDING"));
    }

    public static boolean isValidLocation(String location) {
        return isNotEmpty(location);
    }

    public static boolean isValidEventType(String type) {
        return isNotEmpty(type);
    }

    public static boolean isValidDescription(String desc) {
        return isNotEmpty(desc) && desc.length() >= 10;
    }

    public static boolean isValidDate(java.time.LocalDateTime dateTime) {
        return dateTime != null && dateTime.isAfter(java.time.LocalDateTime.now());
    }

}
