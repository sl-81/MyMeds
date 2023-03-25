package ui;

import model.Drug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DrugRemover extends SelectFromList {

    public DrugRemover(MyMedsUI ui, List<Drug> drugs) {
        super(ui, "Select a drug to remove");
        for (Drug d: drugs) {
            objectList.addItem(d.getName());
        }
        this.add(objectList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String drugName = (String) cb.getSelectedItem();
        ui.removeDrug(drugName);
        ui.runMyMeds();
    }
}
