package gui;

import javax.swing.SwingUtilities;

public class maingui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }
}
