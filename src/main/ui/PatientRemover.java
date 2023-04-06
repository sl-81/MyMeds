package ui;

import model.Patient;
import model.PatientsRecord;
import ui.button.BackToMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// a panel that has a dropdown menu that displays all patient names currently in list and remove upon selection

public class PatientRemover extends SelectFromList {

    // EFFECTS: CONSTRUCTS NEW PATIENT REMOVER PANEL
    public PatientRemover(MyMedsUI ui, PatientsRecord patients) {
        super(ui, "Select a patient to remove");
        for (Patient p: patients) {
            objectList.addItem(p.getName());
        }
        this.add(objectList);
        this.add(new BackToMain(ui, "Back to main"));
        setMaximumSize(new Dimension(400, 100));
    }

    // MODIFIES: UI
    // EFFECTS: GET PATIENT NAME TO BE REMOVED AND GET UI TO REMOVE PATIENT AND RERUN
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> cb = (JComboBox<String>) e.getSource();
        String patientName = (String) cb.getSelectedItem();
        ui.removePatient(patientName);
        ui.runMyMeds();
    }
}
