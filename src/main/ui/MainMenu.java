package ui;

import ui.button.AddPatient;
import ui.button.DisplayGraph;

import javax.swing.*;

public class MainMenu extends JPanel {


    public MainMenu(MyMedsUI ui) {
        add(new AddPatient(ui));
        add(new DisplayGraph(ui));
        add(new JButton("Save"));
        add(new JButton("Load"));
    }
}
