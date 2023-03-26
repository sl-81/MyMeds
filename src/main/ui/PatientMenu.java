package ui;

import ui.button.*;

import javax.swing.*;

// A panel containing all buttons operating on one selected patient
public class PatientMenu extends JPanel {

    // EFFECTS: CONSTRUCTS A NEW PATIENT MENU
    public PatientMenu(MyMedsUI ui) {
        add(new AddDrug(ui, "Add a drug"));
        add(new RemoveDrug(ui, "Remove a drug"));
        add(new SaveFile(ui, "Save current data"));
        add(new LoadFile(ui, "Load last saved data"));
        add(new BackToMain(ui, "Back to main"));
    }
}
