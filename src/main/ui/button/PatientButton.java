package ui.button;

import ui.MyMedsUI;

import javax.swing.*;

public abstract class PatientButton extends JButton {
    protected MyMedsUI ui;

    public PatientButton (String msg) {
        super(msg);
    }

}
