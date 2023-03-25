package ui;

import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class PatientRemover extends SelectFromList {
    public PatientRemover(MyMedsUI ui, List<Patient> patients) {
        super(ui, "Select a patient to remove");
        for (Patient p: patients) {
            objectList.addItem(p.getName());
        }
        this.add(objectList);
        setMaximumSize(new Dimension(400, 100));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> cb = (JComboBox<String>) e.getSource();
        String patientName = (String) cb.getSelectedItem();
        ui.removePatient(patientName);
        ui.runMyMeds();
    }
}
