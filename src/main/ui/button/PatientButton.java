package ui.button;

import ui.MyMedsUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class PatientButton extends JButton implements ActionListener {
    protected MyMedsUI ui;

    public PatientButton(String msg) {
        super(msg);
    }

}
