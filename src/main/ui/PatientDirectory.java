package ui;

import model.Patient;
import model.PatientsRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

// A panel that displays the list of patients currently keeping track of as a dropdown menu
// can select a patient from the menu and view their details

public class PatientDirectory extends SelectFromList {

    //EFFECTS: CREATES A NEW PANEL WITH THE GIVEN LIST OF PATIENTS
    public PatientDirectory(MyMedsUI ui, PatientsRecord patients) {
        super(ui, "Select a patient to view");
        for (Patient p: patients) {
            objectList.addItem(p.getName());
        }
        this.add(objectList);
        setMaximumSize(new Dimension(400, 100));
    }

    // MODIFIES: UI
    // EFFECTS: OBTAIN THE PATIENT NAME SELECTED BY THE USER AND GET UI TO DISPLAY THAT PATIENT'S INFO
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> cb = (JComboBox<String>) e.getSource();
        String patientName = (String) cb.getSelectedItem();
        ui.disPlayPatient(patientName);
    }


}
