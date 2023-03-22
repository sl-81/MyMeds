package ui;

import ui.button.AddPatient;
import ui.button.DisplayGraph;
import ui.button.LoadFile;
import ui.button.SaveFile;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {


    public MainMenu(MyMedsUI ui) {
        add(new AddPatient(ui));
        add(new DisplayGraph(ui));
        add(new SaveFile(ui));
        add(new LoadFile(ui));
        setMaximumSize(new Dimension(1000, 100));
    }
}
