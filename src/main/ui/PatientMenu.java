package ui;

import ui.button.*;

import javax.swing.*;

public class PatientMenu extends JPanel {
    public PatientMenu(MyMedsUI ui) {
        add(new AddDrug(ui));
        add(new RemoveDrug(ui));
        add(new SaveFile(ui));
        add(new LoadFile(ui));
        add(new BackToMain(ui));
    }
}
