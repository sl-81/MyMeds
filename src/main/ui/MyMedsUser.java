package ui;

import model.Patient;
import model.Drug;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyMedsUser {
    private List<Patient> patients;
    private Patient selectedPatient;
    private Scanner input;

    // EFFECTS: generate a new user with a new patients list
    public MyMedsUser() {
        patients = new ArrayList<Patient>();
        try {
            runMyMeds();
        } catch (InputMismatchException i) {
            System.out.println("Please type in a valid year/month/date");
        } catch (DateTimeException d) {
            System.out.println("Please type in a valid year/month/date");
        } finally {
            input.close();
        }

    }

    // MODIFIES: this
    // EFFECTS: initiate selectedPatient to null
    // print all patients and print instructions, takes a new command input from user
    private void runMyMeds() {
        selectedPatient = null;
        input = new Scanner(System.in);
        String command = null;
        printPatients();
        printInstructions();
        command = input.nextLine();
        processCommand(command);

    }

    // EFFECTS: prints the list of Patients
    private void printPatients() {
        for (Patient p: patients) {
            System.out.println(p.getName() + ": " + p.getAge() + " years old");
        }
    }

    // EFFECTS: print a list of commands that user can use
    private void printInstructions() {
        System.out.println("\ntype 'add' to add patient");
        System.out.println("type 'remove' to remove a patient");
        System.out.println("type 'q' to exit");
        System.out.println("type the patient's name to view a patient\n");
    }

    // MODIFIES: this
    // EFFECTS: add a patient to patients
    private void addPatient() throws InputMismatchException, DateTimeException {
        System.out.println("Enter name of patient:");
        String patientName = input.nextLine();
        System.out.println("Enter birth year of patient:");
        int patientYear = input.nextInt();
        System.out.println("Enter birth month of patient:");
        int patientMonth = input.nextInt();
        System.out.println("Enter birth date of patient:");
        int patientDay = input.nextInt();
        input.nextLine();
        Patient newPatient = new Patient(patientName, patientYear, patientMonth, patientDay);
        patients.add(newPatient);
        System.out.println("Added successfully\n");
        runMyMeds();
    }

    // MODIFIES: this
    // EFFECTS: remove a patient from patients
    private void removePatient() {
        System.out.println("Enter name of patient to remove:");
        String patientName = input.nextLine();
        Patient toRemove = null;
        for (Patient p: patients) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                toRemove = p;
            }
        }
        patients.remove(toRemove);
        System.out.println("Removed successfully\n");
        runMyMeds();
    }

    // EFFECTS: return a list of drugs the selected patient is on
    private void printDrugs(Patient p) {
        System.out.println("Medications " + p.getName() + " takes: ");
        List<Drug> drugs = p.getDrugs();
        for (Drug d: drugs) {
            System.out.println(d.getName() + " " + d.getDose() + " "
                    + d.getInstructions() + " for " + d.getIndication());
        }
    }

    // EFFECTS: print new instructions on how to add drugs to a patient's profile
    private void printDrugInstructions() {
        System.out.println("\ntype 'add' to add a new drug");
        System.out.println("type 'remove' to remove an existing drug");
        System.out.println("type 'ud' to update an existing drug's dose");
        System.out.println("type 'ui' to update an existing drug's instructions");
        System.out.println("type 'b' to go back to main");
        System.out.println("type 'q' to exit\n");
    }

    // EFFECTS: handle the commands that the user inputted and run methods as appropriate
    private void processCommand(String command) {
        if (command.equals("add")) {
            addPatient();
        } else if (command.equals("remove")) {
            removePatient();
        } else if (command.equals("q")) {
            input.close();
            System.exit(0);
        } else {
            for (Patient p: patients) {
                if (p.getName().equalsIgnoreCase(command)) {
                    printDrugs(p);
                    printDrugInstructions();
                    command = input.nextLine();
                    processCommandD(p, command);
                }
            }
            System.out.println("Please enter a valid command");
            command = input.nextLine();
            processCommand(command);
        }
    }

    // REQUIRES: selectedPatient must not be null at this point
    // EFFECTS: handle the commands that the user inputted and run methods as appropriate
    private void processCommandD(Patient selectedPatient, String command) {
        this.selectedPatient = selectedPatient;
        if (command.equals("add")) {
            addDrug();
        } else if (command.equals("remove")) {
            removeDrug();
        } else if (command.equals("ud")) {
            updateDose();
        } else if (command.equals("ui")) {
            updateInstructions();
        } else if (command.equals("b")) {
            runMyMeds();
        } else if (command.equals("q")) {
            input.close();
            System.exit(0);
        } else {
            System.out.println("Please enter valid instructions");
            command = input.nextLine();
            processCommandD(selectedPatient, command);
        }

    }

    // MODIFIES: selectedPatient
    // EFFECTS: add a drug to the selectedPatient's list of drugs
    private void addDrug() {
        System.out.println("Enter name of drug:");
        String drugName = input.nextLine();
        System.out.println("Enter dose of drug:");
        String drugDose = input.nextLine();
        System.out.println("Enter instruction of drug:");
        String drugInstruction = input.nextLine();
        System.out.println("Enter indication of drug:");
        String drugIndication = input.nextLine();
        Drug newDrug = new Drug(drugName, drugDose, drugInstruction, drugIndication);
        selectedPatient.addDrug(newDrug);
        System.out.println("Added successfully\n");
        runMyMeds();
    }

    // MODIFIES: selectedPatient
    // EFFECTS: remove a drug from the selectedPatient's list of drugs
    private void removeDrug() {
        System.out.println("Enter name of drug to remove:");
        String drugName = input.nextLine();
        selectedPatient.removeDrug(drugName);
        System.out.println("Removed successfully\n");
        runMyMeds();
    }

    // REQUIRES: name of drug to update entered by the user must be present in selectedPatient's list of drugs
    // MODIFIES: selectedPatient
    // EFFECTS: updates the dose of a drug from the selectedPatient's list of drugs
    private void updateDose() {
        System.out.println("Enter name of an existing drug to update:");
        String drugName = input.nextLine();
        System.out.println("Enter new dose of this drug:");
        String newDose = input.nextLine();
        try {
            selectedPatient.updateDose(drugName, newDose);
        } catch (NullPointerException e) {
            System.out.println("Cannot update non-existent drug\n");
            updateDose();
        }
        System.out.println("Updated successfully\n");
        runMyMeds();
    }

    // REQUIRES: name of drug to update entered by the user must be present in selectedPatient's list of drugs
    // MODIFIES: selectedPatient
    // EFFECTS: updates the instructions of a drug from the selectedPatient's list of drugs
    private void updateInstructions() {
        System.out.println("Enter name of an existing drug to update:");
        String drugName = input.nextLine();
        System.out.println("Enter new instruction of this drug:");
        String newInstructions = input.nextLine();
        try {
            selectedPatient.updateInstructions(drugName, newInstructions);
        } catch (NullPointerException e) {
            System.out.println("Cannot update non-existent drug\n");
            updateInstructions();
        }
        System.out.println("Updated successfully\n");
        runMyMeds();
    }
}
