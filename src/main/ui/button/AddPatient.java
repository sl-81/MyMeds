package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;


// button to add patient to keep track
public class AddPatient extends PatientButton {

    // EFFECTS: CREATES NEW BUTTON
    public AddPatient(MyMedsUI ui, String msg) {
        super(ui, msg);
    }

    // MODIFIES: UI
    // EFFECTS: GET UI TO LOAD PATIENTGETTER UPON CLICK
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.initializePatientGetter();
    }


}
