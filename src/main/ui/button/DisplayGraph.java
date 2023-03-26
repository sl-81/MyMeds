package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;


// button to display a graph upon click
public class DisplayGraph extends PatientButton {

    // EFFECTS: CREATES BUTTON
    public DisplayGraph(MyMedsUI ui) {
        super("Display Patient Drug Graph");
        this.ui = ui;
        addActionListener(this);
    }

    // MODIFIES: UI
    // EFFECTS: GET UI TO GENERATE A GRAPH
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.generateGraph();
    }

}
