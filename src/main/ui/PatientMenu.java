package ui;

import ui.button.AddDrug;
import ui.button.DisplayGraph;
import ui.button.RemoveDrug;

import javax.swing.*;

public class PatientMenu extends JPanel {
    public PatientMenu(MyMedsUI ui) {
        add(new AddDrug(ui));
        add(new RemoveDrug(ui));
        add(new JButton("Save"));
        add(new JButton("Load"));
    }
}
