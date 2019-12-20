package pharmacy.gui;

import pharmacy.log.LogPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setSize(700, 700);

        setTitle("Pharmacy");
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        int posX = width / 2 - getWidth() / 2;
        int posY = height / 2 - getHeight() / 2;
        setLocation(posX, posY);

//        BackgroundPanel backgroundPanel = new BackgroundPanel();
//        add(backgroundPanel);

        LogPanel logPanel = new LogPanel();
        add(logPanel);

    }

    public void logout() {
        this.getContentPane().removeAll();
        this.add(new LogPanel());
        this.revalidate();
    }

    public void panelSwitchOver(JPanel jPanel) {
        this.getContentPane().removeAll();
        this.add(jPanel);
        this.revalidate();
    }
}
