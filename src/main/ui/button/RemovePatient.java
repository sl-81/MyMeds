package ui.button;

import ui.MyMedsUI;
import ui.PatientRemover;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemovePatient extends PatientButton {
    public RemovePatient(MyMedsUI ui) {
        super("Remove a patient");
        this.ui = ui;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.initializePatientRemover();
    }

}
