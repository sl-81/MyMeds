package ui;


import model.Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;

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
        submit.addActionListener(new SubmitInfo());
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

        // MODIFIES: UI
        // EFFECTS: OBTAIN PATIENT INFO FROM SUBMITTED FORM AND GET UI TO ADD PATIENT AND RERUN
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Patient newPatient = new Patient(patientName.getText(), Integer.parseInt(patientYear.getText()),
                        Integer.parseInt(patientMonth.getText()), Integer.parseInt(patientDay.getText()));
                ui.addPatient(newPatient);
                ui.runMyMeds();
            } catch (DateTimeException dte) {
                ui.runMyMeds();
                ui.setMessage("Please enter a valid date");
            } catch (NumberFormatException nfe) {
                ui.runMyMeds();
                ui.setMessage("Please enter valid integers as date");
            }
        }
    }

}
