package ui;

import model.Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PatientDirectory extends JComboBox {
    private MyMedsUI ui;
    private ActionListener select;

    public PatientDirectory(MyMedsUI ui, List<Patient> patients) {
        this.ui = ui;
        addItem("Select a patient to view");
        for (Patient p: patients) {
            addItem(p.getName());
        }
        select = new HandlePatientSelection();
        addActionListener(select);
    }

    private class HandlePatientSelection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String patientName = (String) cb.getSelectedItem();
            ui.disPlayPatient(patientName);
        }
    }

}
