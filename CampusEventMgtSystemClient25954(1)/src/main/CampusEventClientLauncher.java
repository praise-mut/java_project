package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Login;

public class CampusEventClientLauncher {

    public static void main(String[] args) {
        try {
            // Set system look and feel for native UI
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.err.println("Warning: Failed to set look and feel.");
            ex.printStackTrace();
        }

        // Launch the login form (initial window)
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}


/*

*/

