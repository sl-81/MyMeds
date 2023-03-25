package ui;

import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class PatientDirectory extends SelectFromList {

    public PatientDirectory(MyMedsUI ui, List<Patient> patients) {
        super(ui, "Select a patient to view");
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
        ui.disPlayPatient(patientName);
    }


}
