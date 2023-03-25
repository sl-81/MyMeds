package ui;

import model.Drug;
import model.Patient;

import javax.swing.*;

public class PatientPanel extends JPanel {

    public PatientPanel(Patient p) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Medications " + p.getName() + " takes: "));
        for (Drug d: p.getDrugs()) {
            JLabel drugInfo = new JLabel(d.getName() + " " + d.getDose() + " "
                    + d.getInstructions() + " for " + d.getIndication());
            add(drugInfo);
        }
    }
}
