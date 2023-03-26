package ui;

import ui.button.*;

import javax.swing.*;
import java.awt.*;

// a panel that display the main menu buttons operating on the list of patients
public class MainMenu extends JPanel {

    // EFFECTS: CONSTRUCTS A NEW MAINMENU PANEL
    public MainMenu(MyMedsUI ui) {
        add(new AddPatient(ui));
        add(new RemovePatient(ui));
        add(new DisplayGraph(ui));
        add(new SaveFile(ui));
        add(new LoadFile(ui));
        setMaximumSize(new Dimension(1000, 100));
    }
}
