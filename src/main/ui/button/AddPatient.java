package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddPatient extends PatientButton {

    public AddPatient(MyMedsUI ui) {
        super("Add a patient");
        this.ui = ui;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.initializePatientGetter();
    }


}
