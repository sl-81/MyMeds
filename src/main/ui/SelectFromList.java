package ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class SelectFromList extends JPanel implements ActionListener {
    protected MyMedsUI ui;
    protected JComboBox<String> objectList;

    public SelectFromList (MyMedsUI ui, String userInstructions) {
        this.ui = ui;
        objectList = new JComboBox<>();
        objectList.addItem(userInstructions);
        objectList.addActionListener(this);
    }
}
