package ui.button;

import ui.MyMedsUI;

import javax.swing.*;
import java.awt.event.ActionListener;

// abstract button for all menu buttons to extend from
public abstract class PatientButton extends JButton implements ActionListener {
    protected MyMedsUI ui;

    // EFFECTS: CREATES BUTTON
    public PatientButton(MyMedsUI ui, String msg) {
        super(msg);
        this.ui = ui;
        addActionListener(this);
    }

}
