package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFile extends PatientButton {

    public SaveFile(MyMedsUI ui) {
        super("Save current data");
        this.ui = ui;
        addActionListener(new FileSaver());
    }

    private class FileSaver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ui.saveList();
        }
    }
}
