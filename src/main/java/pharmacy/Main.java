package pharmacy;

import pharmacy.gui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static MainFrame mainFrame = new MainFrame();

    public static void main(String[] args) {

        EventQueue.invokeLater(() ->{
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
        });
    }
}