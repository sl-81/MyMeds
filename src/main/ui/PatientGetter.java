package ui;


import model.Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// a panel that contains the form to get user input on a new patient to be added

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

    // EFFECTS: CREATES A NEW PANEL DISPLAYING FORM
    public PatientGetter(MyMedsUI ui) {
        this.ui = ui;
        initializeForm();
        setVisible(true);
    }

    // EFFECTS: PLACE AVAILABLE FIELDS OF FORM ONTO THE PANEL
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

    // ACTIONLISTENER FOR THE SUBMIT BUTTON
    private class SubmitInfo implements ActionListener {
        private PatientGetter pg;

        // EFFECTS: CREATE NEW ACTIONLISTENER
        private SubmitInfo(PatientGetter pg) {
            this.pg = pg;
        }

        // EFFECTS: OBTAIN PATIENT INFO FROM SUBMITTED FORM AND GET UI TO ADD PATIENT AND RERUN
        @Override
        public void actionPerformed(ActionEvent e) {
            Patient newPatient = new Patient(patientName.getText(), Integer.valueOf(patientYear.getText()),
                    Integer.valueOf(patientMonth.getText()), Integer.valueOf(patientDay.getText()));
            ui.addPatient(newPatient);
            ui.runMyMeds();
        }
    }

}
