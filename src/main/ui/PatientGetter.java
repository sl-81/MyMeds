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
    private JTextField patientName;
    private JTextField patientYear;
    private JTextField patientMonth;
    private JTextField patientDay;

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
        patientName = new JTextField(15);
        patientYear = new JTextField(15);
        patientMonth = new JTextField(15);
        patientDay = new JTextField(15);
        submit = new JButton("Submit");
        submit.addActionListener(new SubmitInfo(this));
        add(getName);
        add(patientName);
        add(getYear);
        add(patientYear);
        add(getMonth);
        add(patientMonth);
        add(getDay);
        add(patientDay);
        add(submit);
    }

    private class SubmitInfo implements ActionListener {
        private PatientGetter pg;

        private SubmitInfo(PatientGetter pg) {
            this.pg = pg;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Patient newPatient = new Patient(patientName.getText(), Integer.valueOf(patientYear.getText()),
                    Integer.valueOf(patientMonth.getText()), Integer.valueOf(patientDay.getText()));
            ui.addPatient(newPatient);
            ui.runMyMeds();
        }
    }

}
