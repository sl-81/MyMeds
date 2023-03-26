package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToMain extends PatientButton {
    public BackToMain(MyMedsUI ui) {
        super("Back to main");
        this.ui = ui;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.runMyMeds();
    }

}
