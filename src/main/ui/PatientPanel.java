package ui;

import model.Drug;
import model.Patient;

import javax.swing.*;

// A panel that displays the patient's information along with the operations that can be performed as buttons
public class PatientPanel extends JPanel {

    // EFFECTS: CONSTRUCTS THE NEW PATIENTPANEL
    public PatientPanel(Patient p) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLoweredBevelBorder());
        add(new JLabel("Medications " + p.getName() + " takes: "));
        for (Drug d: p.getDrugs()) {
            JLabel drugInfo = new JLabel(d.getName() + " " + d.getDose() + " "
                    + d.getInstructions() + " for " + d.getIndication());
            add(drugInfo);
        }
    }
}
