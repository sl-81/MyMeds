package ui;

import javax.swing.*;
import java.awt.event.ActionListener;

// Abstract panel with JComboBox that all classes that needs a JCombobox can extend
public abstract class SelectFromList extends JPanel implements ActionListener {
    protected MyMedsUI ui;
    protected JComboBox<String> objectList;

    // EFFECTS: CONSTRUCTS THE PANEL
    public SelectFromList(MyMedsUI ui, String userInstructions) {
        this.ui = ui;
        objectList = new JComboBox<>();
        objectList.addItem(userInstructions);
        objectList.addActionListener(this);
    }
}
