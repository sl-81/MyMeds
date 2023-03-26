package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;


// button to save current file
public class SaveFile extends PatientButton {

    // EFFECTS: CREATES BUTTON
    public SaveFile(MyMedsUI ui, String msg) {
        super(ui, msg);
    }

    // MODIFIES: UI
    // EFFECTS: GET UI TO SAVE LIST TO JSON FILE
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.saveList();
    }

}
