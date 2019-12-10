package pharmacy.log;

import javax.swing.*;

public class LogFrame extends JFrame {

    public LogFrame() {
        setSize(700,700);
        setResizable(false);
        setTitle("Log in");
        setLocationRelativeTo(null);

        LogPanel logPanel = new LogPanel();

        add(logPanel);
    }

}
