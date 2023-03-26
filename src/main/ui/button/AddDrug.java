package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;

// the button to add drug upon click
public class AddDrug extends PatientButton {

    // EFFECTS: CREATES THE BUTTON
    public AddDrug(MyMedsUI ui, String msg) {
        super(ui, msg);
    }

    // MODIFIES: UI
    // EFFECTS: GET UI TO INITIALIZE DRUGGETTER UPON CLICK
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.initializeDrugGetter();
    }

}
