package ui;

import ui.button.*;

import javax.swing.*;

// A panel containing all buttons operating on one selected patient
public class PatientMenu extends JPanel {

    // EFFECTS: CONSTRUCTS A NEW PATIENT MENU
    public PatientMenu(MyMedsUI ui) {
        add(new AddDrug(ui));
        add(new RemoveDrug(ui));
        add(new SaveFile(ui));
        add(new LoadFile(ui));
        add(new BackToMain(ui));
    }
}
