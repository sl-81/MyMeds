package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrug extends PatientButton {

    public AddDrug(MyMedsUI ui) {
        super("Add a drug");
        this.ui = ui;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.initializeDrugGetter();
    }

}
