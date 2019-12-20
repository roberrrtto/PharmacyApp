package pharmacy.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BackgroundPanel extends JPanel {

    private BufferedImage img;

    public BackgroundPanel() {
        setOpaque(true);
        try {
            img = ImageIO.read(getClass().getResource("/LogoAndBackground.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }
}
