package ui;

import model.Patient;
import model.Drug;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class myMedsUser {
    private List<Patient> patients;
    private Scanner input;

    public myMedsUser(){
        patients = new ArrayList<Patient>();
        runMyMeds();
    }

    private void runMyMeds() {
        input = new Scanner(System.in);
        String command = null;

        init();

        command = input.next();

        processCommandP(command);


    }

    private void init() {
        for (Patient p: patients) {
            System.out.println(p.getName() + ": " + p.getAge() +" years old");
        }
        System.out.println("type 'add' to add patient");
        System.out.println("type 'remove' to remove a patient");
        System.out.println("type 'q' to exit");
        System.out.println("type the patient's name to view a patient");

    }

    private void addPatient() {
        Scanner getName = new Scanner(System.in);
        System.out.println("Enter name of patient:");
        String patientName = getName.next();
        Scanner getYear = new Scanner(System.in);
        System.out.println("Enter birth year of patient:");
        int patientYear = getYear.nextInt();
        Scanner getMonth = new Scanner(System.in);
        System.out.println("Enter birth month of patient:");
        int patientMonth = getMonth.nextInt();
        Scanner getDay = new Scanner(System.in);
        System.out.println("Enter birth date of patient:");
        int patientDay = getDay.nextInt();
        Patient newPatient = new Patient (patientName, patientYear, patientMonth, patientDay);
        patients.add(newPatient);
        System.out.println("Added successfully");
        runMyMeds();
    }

    private void removePatient() {
        Scanner getName = new Scanner(System.in);
        System.out.println("Enter name of patient:");
        String patientName = getName.next();
        Patient toRemove = null;
        for (Patient p: patients) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                toRemove = p;
            }
        }
        patients.remove(toRemove);
        runMyMeds();
    }


    private void printDrugs(Patient p) {

    }


    private void processCommandP(String command) {
        if (command.equals("add")) {
            addPatient();
        } else if (command.equals("remove")) {
            removePatient();
        } else if (command.equals("q")) {
            // !!! exit
        } else {
            for (Patient p: patients) {
                if (p.getName().equalsIgnoreCase(command)){
                    printDrugs(p);
                }
            }
        }
    }


}
