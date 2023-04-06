package ui;


import model.Drug;
import model.Event;
import model.EventLog;
import model.Patient;
import model.PatientsRecord;
import persistence.FileReader;
import persistence.FileWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// initiates the app
public class MyMedsUI extends JFrame implements WindowListener {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static String location = "./data/mymeds.json";
    private JPanel main;
    private MainMenu mainMenu;
    private PatientDirectory patientDirectory;
    private PatientMenu patientMenu;
    private JLabel message;
    private FileReader reader;
    private FileWriter writer;
    private PatientsRecord patients;
    private Patient selectedPatient;

    // EFFECTS: CREATES NEW JFRAME AND INITIALIZES AN EMPTY PATIENT LIST
    public MyMedsUI() {
        super("My Meds");
        patients = new PatientsRecord();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        addWindowListener(this);
        runMyMeds();
    }

    // MODIFIES: THIS
    // EFFECTS: REMOVE ALL COMPONENTS, RESET SELECTED PATIENT, ADD NEW MAINMENU AND PATIENTDIRECTORY
    public void runMyMeds() {
        getContentPane().removeAll();
        repaint();
        selectedPatient = null;
        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        mainMenu = new MainMenu(this);
        patientDirectory = new PatientDirectory(this, patients);
        message = new JLabel("", JLabel.CENTER);
        main.add(mainMenu);
        main.add(patientDirectory);
        main.add(message);
        add(main);
        setVisible(true);
    }

    // EFFECTS: HIDE THE FRONTPAGE, DISPLAY FORM TO OBTAIN NEW PATIENT INFO FROM USER
    public void initializePatientGetter() {
        hideFrontPage();
        PatientGetter pg = new PatientGetter(this);
        main.add(pg);
    }

    // MODIFIES: this
    // EFFECTS: add a patient to patients
    public void addPatient(Patient p) {
        patients.add(p);
    }

    // EFFECTS: HIDE THE FRONT PAGE, DISPLAY DROPDOWN MENU WITH CURRENT PATIENT TO GET PATIENT TO REMOVE FROM USER
    public void initializePatientRemover() {
        hideFrontPage();
        PatientRemover pr = new PatientRemover(this, patients);
        main.add(pr);
    }

    // MODIFIES: this
    // EFFECTS: remove a patient from patients
    public void removePatient(String patientName) {
        Patient toRemove = null;
        for (Patient p: patients) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                toRemove = p;
            }
        }
        patients.remove(toRemove);
    }

    // MODIFIES: THIS
    // EFFECTS: DISPLAY INFO FOR THE PATIENT USER SELECTED, AND DISPLAY OPERATIONS USER CAN PERFORM ON ONE PATIENT
    public void disPlayPatient(String patientName) {
        hideFrontPage();
        for (Patient p: patients) {
            if (p.getName().equals(patientName)) {
                selectedPatient = p;
            }
        }
        if (selectedPatient != null) {
            JPanel selectedPatientInfo = new PatientPanel(selectedPatient);
            main.add(selectedPatientInfo);
            patientMenu = new PatientMenu(this);
            main.add(patientMenu);
        } else {
            runMyMeds();
        }
    }

    // MODIFIES: THIS
    // EFFECTS: DISPLAY A GRAPH OF PATIENT AND NUMBER OF DRUGS THEY'RE ON
    public void generateGraph() {
        hideFrontPage();
        List<Integer> drugCount = new ArrayList<>();
        List<String> patientNames = new ArrayList<>();
        for (Patient p: patients) {
            drugCount.add(p.getDrugs().size());
            patientNames.add(p.getName());
        }

        JPanel graph = new BarChart(this, drugCount, patientNames, "Patient and Number of Drugs");
        main.add(graph);
    }

    // MODIFIES: THIS
    // EFFECTS: DISPLAY A FORM TO GET INFO OF NEW DRUG TO BE ADDED TO LIST FROM THE USER
    public void initializeDrugGetter() {
        hidePatientMenu();
        DrugGetter dg = new DrugGetter(this);
        main.add(dg);
    }

    // MODIFIES: selectedPatient
    // EFFECTS: add a drug to the selectedPatient's list of drugs
    public void addDrug(Drug newDrug) {
        selectedPatient.addDrug(newDrug);
    }

    // MODIFIES: THIS
    // EFFECTS: DISPLAY A DROPDOWN MENU OF ALL OF PATIENT'S DRUG AND GET INFO FROM USER ABOUT WHICH ONE TO REMOVE
    public void initializeDrugRemover() {
        hidePatientMenu();
        DrugRemover dr = new DrugRemover(this, selectedPatient.getDrugs());
        main.add(dr);
    }

    // MODIFIES: selectedPatient
    // EFFECTS: remove a drug from the selectedPatient's list of drugs
    public void removeDrug(String drugName) {
        selectedPatient.removeDrug(drugName);
    }

    // EFFECTS: save the current list of patients and any updated drug lists
    public void saveList() {
        writer = new FileWriter(location);
        try {
            writer.open();
            writer.write(patients);
        } catch (FileNotFoundException e) {
            main.add(new JLabel("Error: cannot write file at location"));
        } finally {
            writer.close();
            runMyMeds();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads the previously saved patient and drug lists
    public void loadList() {
        reader = new FileReader(location);
        try {
            patients = reader.read();
        } catch (IOException e) {
            main.add(new JLabel("Error: file not found"));
        } finally {
            runMyMeds();
        }
    }

    // MODIFIES: THIS
    // EFFECTS: HIDE THE MAINMENU AND PATIENTDIRECTORY WHILE SELECTED PATIENT IS NOT NULL
    private void hideFrontPage() {
        mainMenu.setVisible(false);
        patientDirectory.setVisible(false);
        message.setVisible(false);
    }

    // MODIFIES: THIS
    // EFFECTS: HIDE PATIENT MENU
    private void hidePatientMenu() {
        patientMenu.setVisible(false);
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

    private void printEventLog() {
        for (Event e: EventLog.getInstance()) {
            System.out.println(e.getDescription());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        printEventLog();
        EventLog.getInstance().clear();
        System.exit(0);
    }


    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}