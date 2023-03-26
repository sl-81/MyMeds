package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;

// button to go back to front page
public class BackToMain extends PatientButton {

    // EFFECTS: CREATES BUTTON
    public BackToMain(MyMedsUI ui, String msg) {
        super(ui, msg);
    }

    // MODIFIES: UI
    // EFFECTS: GET UI TO GO BACK TO MAIN
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.runMyMeds();
    }

}
