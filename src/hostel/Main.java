package hostel;

import hostel.ui.MainGUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI app = new MainGUI();
            app.setLocationRelativeTo(null);
            app.setVisible(true);
        });
    }
}