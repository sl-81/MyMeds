package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddPatient extends PatientButton {

    public AddPatient(MyMedsUI ui) {
        super("Add a patient");
        this.ui = ui;
        addActionListener(new PatientAdder());
    }

    private class PatientAdder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ui.initializePatientGetter();
        }
    }

}
