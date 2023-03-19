package ui;


import model.Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientGetter extends JPanel {
    private JButton submit;
    private MyMedsUI ui;
    private JLabel getName;
    private JLabel getYear;
    private JLabel getMonth;
    private JLabel getDay;
    private JTextField pName;
    private JTextField pYear;
    private JTextField pMonth;
    private JTextField pDay;

    public PatientGetter(MyMedsUI ui) {
        this.ui = ui;
        initializeForm();
        setVisible(true);
    }

    private void initializeForm() {
        getName = new JLabel("Name:");
        getYear = new JLabel("Year:");
        getMonth = new JLabel("Month:");
        getDay = new JLabel("Day:");
        pName = new JTextField(15);
        pYear = new JTextField(15);
        pMonth = new JTextField(15);
        pDay = new JTextField(15);
        submit = new JButton("Submit");
        submit.addActionListener(new SubmitInfo(this));
        add(getName);
        add(pName);
        add(getYear);
        add(pYear);
        add(getMonth);
        add(pMonth);
        add(getDay);
        add(pDay);
        add(submit);
    }

    private class SubmitInfo implements ActionListener {
        private PatientGetter pg;
        private SubmitInfo(PatientGetter pg) {
            this.pg = pg;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Patient newPatient = new Patient (pName.getText(), Integer.valueOf(pYear.getText()), Integer.valueOf(pMonth.getText()), Integer.valueOf(pDay.getText()));
            ui.addPatient(newPatient);
            ui.runMyMeds();
            pg.setVisible(false);
        }
    }

}
