package ui;

import ui.button.*;

import javax.swing.*;
import java.awt.*;

// a panel that display the main menu buttons operating on the list of patients
public class MainMenu extends JPanel {

    // EFFECTS: CONSTRUCTS A NEW MAINMENU PANEL
    public MainMenu(MyMedsUI ui) {
        add(new AddPatient(ui, "Add a patient"));
        add(new RemovePatient(ui, "Remove a patient"));
        add(new DisplayGraph(ui, "Display Patient Drug Graph"));
        add(new SaveFile(ui, "Save current data"));
        add(new LoadFile(ui, "Load last saved data"));
        setMaximumSize(new Dimension(1000, 100));
    }
}
