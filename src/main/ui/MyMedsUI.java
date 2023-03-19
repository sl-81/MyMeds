package ui;


import model.Drug;
import model.Patient;
import persistence.FileReader;
import persistence.FileWriter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// initiates the app
public class MyMedsUI extends JFrame {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static String location = "./data/mymeds.json";
    private JPanel main;
    private MainMenu mainMenu;
    private PatientDirectory patientDirectory;
    private PatientMenu patientMenu;
    private FileReader reader;
    private FileWriter writer;
    private List<Patient> patients;
    private Patient selectedPatient;

    public MyMedsUI() {
        super("My Meds");
        patients = new ArrayList<>();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        runMyMeds();
    }

    public void runMyMeds() {
        setVisible(false);
        selectedPatient = null;
        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        mainMenu = new MainMenu(this);
        patientDirectory = new PatientDirectory(this, patients);
        main.add(mainMenu);
        main.add(patientDirectory);
        add(main);
        setVisible(true);
    }



    public void initializePatientMenu() {
        JPanel patientMenuButtons = new JPanel();
        patientMenuButtons.add(new JButton("Add"));
        patientMenuButtons.add(new JButton("Remove"));
        patientMenuButtons.add(new JButton("Update Dose"));
        patientMenuButtons.add(new JButton("Update Instructions"));
        patientMenuButtons.add(new JButton("Load"));
        patientMenuButtons.add(new JButton("Save"));
        add(patientMenuButtons, -1);
    }

    public void initializePatientGetter() {
        hideMainMenu();
        hidePatientDirectory();
        PatientGetter pg = new PatientGetter(this);
        main.add(pg);
    }

    public void hideMainMenu() {
        mainMenu.setVisible(false);
    }

    public void hidePatientDirectory() {
        patientDirectory.setVisible(false);
    }

    public void hidePatientMenu() {
        patientMenu.setVisible(false);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void disPlayPatient(String patientName) {
        hideMainMenu();
        hidePatientDirectory();
        for (Patient p: patients) {
            if(p.getName() == patientName) {
                selectedPatient = p;
            }
        }
        if (selectedPatient != null) {
            JPanel selectedPatientInfo = new JPanel();
            selectedPatientInfo.add(new JLabel("Medications " + selectedPatient.getName() + " takes: "));
            for (Drug d: selectedPatient.getDrugs()) {
                JLabel drugInfo = new JLabel(d.getName() + " " + d.getDose() + " "
                        + d.getInstructions() + " for " + d.getIndication());
                selectedPatientInfo.add(drugInfo);
            }
            main.add(selectedPatientInfo);
            patientMenu = new PatientMenu(this);
            main.add(patientMenu);
        }
    }

    public void generateGraph() {
        hideMainMenu();
        hidePatientDirectory();
        List<Integer> drugCount = new ArrayList<>();
        List<String> patientNames = new ArrayList<>();
        for (Patient p: patients) {
            drugCount.add(p.getDrugs().size());
            patientNames.add(p.getName());
        }

        JPanel graph = new BarChart(this, drugCount, patientNames, "Patient and Number of Drugs");
        main.add(graph);
    }

    public void initializeDrugGetter() {
        hidePatientMenu();
        DrugGetter dg = new DrugGetter(this);
        main.add(dg);
    }

    public void addDrug(Drug newDrug) {
        selectedPatient.addDrug(newDrug);
    }

    public void initializeDrugRemover() {
    }
}