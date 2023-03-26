package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;


// button to remove a drug from the patient's file
public class RemoveDrug extends PatientButton {

    //EFFECTS: CREATES THE BUTTON
    public RemoveDrug(MyMedsUI ui) {

        super("Remove a drug");
        this.ui = ui;
        addActionListener(this);
    }

    // MODIFIES: UI
    // EFFECTS: GET UI TO LOAD DRUG REMOVER
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.initializeDrugRemover();
    }

}
