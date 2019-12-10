package pharmacy.guiTest;

import javax.swing.*;

public class UIFrame extends JFrame {

    public UIFrame() {
        setSize(500,600);
        setTitle("SQL Queries");
        setResizable(false);

        UIPanel uiPanel = new UIPanel();
        add(uiPanel);
    }
}
