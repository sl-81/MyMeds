package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;

// button to load a previous saved file upon click
public class LoadFile extends PatientButton {

    // EFFECTS: CREATES BUTTON
    public LoadFile(MyMedsUI ui, String msg) {
        super(ui, msg);
    }

    // MODIFIES: UI
    // EFFECTS: GET UI TO LOAD LIST
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.loadList();
    }
}
