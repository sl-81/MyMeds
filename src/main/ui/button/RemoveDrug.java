package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveDrug extends PatientButton {
    public RemoveDrug(MyMedsUI ui) {

        super("Remove a drug");
        this.ui = ui;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.initializeDrugRemover();
    }

}
