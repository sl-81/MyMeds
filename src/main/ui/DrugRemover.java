package ui;

import model.Drug;
import ui.button.BackToMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

// Represents a panel to remove a drug from a dropdown menu
public class DrugRemover extends SelectFromList {

    // EFFECTS: CREATES A NEW PANEL WITH A DROPDOWN MENU DISPLAYING ALL DRUGS OF THE PATIENT SELECTED
    public DrugRemover(MyMedsUI ui, List<Drug> drugs) {
        super(ui, "Select a drug to remove");
        for (Drug d: drugs) {
            objectList.addItem(d.getName());
        }
        this.add(objectList);
        this.add(new BackToMain(ui, "Back to main"));
    }

    // MODIFIES: UI
    // EFFECTS: GET THE DRUG NAME FROM USER'S SELECTION AND GET UI TO REMOVE THE DRUG AND RERUN
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String drugName = (String) cb.getSelectedItem();
        ui.removeDrug(drugName);
        ui.runMyMeds();
    }
}
