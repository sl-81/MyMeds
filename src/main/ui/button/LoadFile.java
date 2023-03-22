package ui.button;

import ui.MyMedsUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFile extends PatientButton {
    public LoadFile(MyMedsUI ui) {
        super("Load last saved data");
        this.ui = ui;
        addActionListener(new FileLoader());
    }

    private class FileLoader implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ui.loadList();
        }
    }
}
