package ui;


import javax.swing.*;
import java.awt.*;

// initiates the app
public class MyMedsUI extends JFrame {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;

    public MyMedsUI() {
        super("My Meds");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        // initializePatientButtons();
        initializeMainMenu();
        JPanel patientList = new JPanel();
        patientList.setLayout();
        setVisible(true);
    }

    public static void main(String[] args) {

        new MyMedsUI();

    }

    public void initializePatientButtons() {

    }

    public void initializeMainMenu() {

    }

    public void initializePatientMenu() {}
}