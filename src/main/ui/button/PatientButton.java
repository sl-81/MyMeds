package ui.button;

import ui.MyMedsUI;

import javax.swing.*;
import java.awt.event.ActionListener;

// abstract button for all menu buttons to extend from
public abstract class PatientButton extends JButton implements ActionListener {
    protected MyMedsUI ui;

    // EFFECTS: CREATES BUTTON
    public PatientButton(String msg) {
        super(msg);
    }

}
