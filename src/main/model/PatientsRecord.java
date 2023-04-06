package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatientsRecord implements Iterable<Patient> {
    private List<Patient> patients = new ArrayList<>();

    public List<Patient> getPatientsOnMeds() {
        List<Patient> patientsOnMeds = new ArrayList<>();
        for (Patient p: patients) {
            if (p.getDrugs().size() > 0) {
                patientsOnMeds.add(p);
            }
        }
        return patientsOnMeds;
    }

    public void add(Patient p) {
        patients.add(p);
        EventLog.getInstance().logEvent(new Event("Added " + p.getName() + " to record."));
    }

    public void remove(Patient p) {
        patients.remove(p);
        EventLog.getInstance().logEvent(new Event("Removed " + p.getName() + " from record."));
    }

    public int getTotalPatientCount() {
        return patients.size();
    }

    public Patient getPatientAtIndex(int index) {
        return patients.get(index);
    }
    @Override
    public Iterator<Patient> iterator() {
        return patients.iterator();
    }
}
