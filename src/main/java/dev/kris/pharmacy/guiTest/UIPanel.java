package dev.kris.pharmacy.guiTest;

import javax.swing.*;
import java.util.Arrays;

public class UIPanel extends JPanel {



    JList<String> jList;

    public UIPanel() {
        setLayout(null);

        String[] name = new String[2];
        name[0] = "Krzy War";
        name[1] = "Alma War";

        jList = new JList<>(name);
        jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        jList.setLayoutOrientation(JList.VERTICAL);
//        jList.setVisibleRowCount(-1);
        jList.setBounds(120,20,250,70);

        add(jList);

    }
}
