package ui;


import model.Drug;
import model.Patient;
import persistence.FileReader;
import persistence.FileWriter;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        getContentPane().removeAll();
        repaint();
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

    public void initializePatientGetter() {
        hideFrontPage();
        PatientGetter pg = new PatientGetter(this);
        main.add(pg);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void initializePatientRemover() {
        hideFrontPage();
        PatientRemover pr = new PatientRemover(this, patients);
        main.add(pr);
    }

    public void removePatient(String patientName) {
        Patient toRemove = null;
        for (Patient p: patients) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                toRemove = p;
            }
        }
        patients.remove(toRemove);
    }

    public void disPlayPatient(String patientName) {
        hideFrontPage();
        for (Patient p: patients) {
            if (p.getName() == patientName) {
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

    public void initializeDrugGetter() {
        hidePatientMenu();
        DrugGetter dg = new DrugGetter(this);
        main.add(dg);
    }

    public void addDrug(Drug newDrug) {
        selectedPatient.addDrug(newDrug);
    }

    public void initializeDrugRemover() {
        hidePatientMenu();
        DrugRemover dr = new DrugRemover(this, selectedPatient.getDrugs());
        main.add(dr);
    }

    public void removeDrug(String drugName) {
        selectedPatient.removeDrug(drugName);
    }

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

    private void hideFrontPage() {
        mainMenu.setVisible(false);
        patientDirectory.setVisible(false);
    }

    private void hidePatientMenu() {
        patientMenu.setVisible(false);
    }

}