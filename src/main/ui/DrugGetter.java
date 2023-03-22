package ui;

import model.Drug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrugGetter extends JPanel {
    private JButton submit;
    private MyMedsUI ui;
    private JLabel getName;
    private JLabel getDose;
    private JLabel getInstructions;
    private JLabel getIndications;
    private JTextField name;
    private JTextField dose;
    private JTextField instructions;
    private JTextField indications;

    public DrugGetter(MyMedsUI ui) {
        this.ui = ui;
        initializeForm();
        setVisible(true);
    }

    private void initializeForm() {
        getName = new JLabel("Name of Drug:");
        getDose = new JLabel("Dose of Drug:");
        getInstructions = new JLabel("Instructions:");
        getIndications = new JLabel("Indications:");
        name = new JTextField(10);
        dose = new JTextField(10);
        instructions = new JTextField(10);
        indications = new JTextField(10);
        submit = new JButton("Submit");
        submit.addActionListener(new SubmitInfo(this));
        add(getName);
        add(name);
        add(getDose);
        add(dose);
        add(getInstructions);
        add(instructions);
        add(getIndications);
        add(indications);
        add(submit);
    }

    private class SubmitInfo implements ActionListener {
        private DrugGetter dg;
        public SubmitInfo(DrugGetter drugGetter) {
            dg = drugGetter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Drug newDrug = new Drug(name.getText(), dose.getText(), instructions.getText(), indications.getText());
            ui.addDrug(newDrug);
            ui.runMyMeds();
        }
    }
}
