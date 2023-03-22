package ui;

import model.Drug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DrugRemover extends JPanel implements ActionListener {
    private MyMedsUI ui;
    private JComboBox drugList;

    public DrugRemover(MyMedsUI ui, List<Drug> drugs) {
        this.ui = ui;
        drugList = new JComboBox<>();
        drugList.addItem("Select a drug to remove");
        for (Drug d: drugs) {
            drugList.addItem(d.getName());
        }
        this.add(drugList);
        drugList.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String drugName = (String) cb.getSelectedItem();
        ui.removeDrug(drugName);
        ui.runMyMeds();
    }
}
