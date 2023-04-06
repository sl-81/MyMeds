package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// represents a list of patient that the app is currently keeping track of
public class PatientsRecord implements Iterable<Patient> {
    private List<Patient> patients = new ArrayList<>();

    // EFFECTS: RETURNS ONLY THE PATIENTS THAT ARE TAKING DRUGS
    public List<Patient> getPatientsOnMeds() {
        List<Patient> patientsOnMeds = new ArrayList<>();
        for (Patient p: patients) {
            if (p.getDrugs().size() > 0) {
                patientsOnMeds.add(p);
            }
        }
        return patientsOnMeds;
    }

    // EFFECTS: ADDS P TO THE LIST OF PATIENTS AND LOG ACTIVITY
    public void add(Patient p) {
        patients.add(p);
        EventLog.getInstance().logEvent(new Event("Added " + p.getName() + " to record."));
    }

    // EFFECTS: REMOVE P FROM THE LIST OF PATIENTS AND LOG ACTIVITY
    public void remove(Patient p) {
        patients.remove(p);
        EventLog.getInstance().logEvent(new Event("Removed " + p.getName() + " from record."));
    }

    // EFFECTS: RETURNS THE TOTAL NUMBER OF PATIENTS IN LIST
    public int getTotalPatientCount() {
        return patients.size();
    }

    // EFFECTS: RETURNS THE PATIENT AT THE INDEX IN PATIENTS
    public Patient getPatientAtIndex(int index) {
        return patients.get(index);
    }

    @Override
    public Iterator<Patient> iterator() {
        return patients.iterator();
    }
}
