package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFile extends PatientButton {

    public SaveFile(MyMedsUI ui) {
        super("Save current data");
        this.ui = ui;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.saveList();
    }

}
