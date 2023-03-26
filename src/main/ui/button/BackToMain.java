package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;

// button to go back to front page
public class BackToMain extends PatientButton {

    // EFFECTS: CREATES BUTTON
    public BackToMain(MyMedsUI ui) {
        super("Back to main");
        this.ui = ui;
        addActionListener(this);
    }

    // MODIFIES: UI
    // EFFECTS: GET UI TO GO BACK TO MAIN
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.runMyMeds();
    }

}
