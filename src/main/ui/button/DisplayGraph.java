package ui.button;

import ui.MyMedsUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DisplayGraph extends PatientButton {

    public DisplayGraph(MyMedsUI ui) {
        super("Display Patient Drug Graph");
        this.ui = ui;
        addActionListener(new GraphGenerator());
    }

    private class GraphGenerator implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ui.generateGraph();
        }
    }
}
