package ui.button;

import ui.MyMedsUI;
import java.awt.event.ActionEvent;

// button to remove patient from ui upon click
public class RemovePatient extends PatientButton {

    // EFFECTS: CREATES BUTTON
    public RemovePatient(MyMedsUI ui, String msg) {
        super(ui, msg);
    }

    // MODIFIES: UI
    // EFFECTS: GET UI TO LOAD PATIENT REMOVER
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.initializePatientRemover();
    }

}
