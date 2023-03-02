package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.DateTimeException;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

// Represents a person with a list of medical conditions to manage and a list of medications they take
// identified by their name and birthday and age

public class Patient {
    private String name;
    private LocalDate birthday;
    private int age;
    private List<Drug> drugs;

    // CONSTRUCTOR, CREATES NEW PATIENT WITH NO DRUGS AND CONDITIONS GIVEN NAME AND BIRTHDAY
    // REQUIRES: name must be unique
    // year must be =< 130 from current year, month must be =< 12
    // day must be =<31 for months = 1,3,5,7,8,10,12, =<30 for months = 4,6,9,11,
    // =<28 for months=2 and not leap year, =<29 for months=2 and leap year
    // EFFECTS: CREATES A NEW PATIENT
    public Patient(String name, int year, int month, int day) throws DateTimeException {
        this.name = name;
        this.birthday = LocalDate.of(year, month, day);
        this.age = LocalDate.now().getYear() - year;
        this.drugs = new ArrayList<>();
    }


    // MODIFIES: THIS
    // EFFECTS: add a drug to drugs, if the exact same drug (by name) is in there, do nothing
    public void addDrug(Drug d) {
        boolean contains = false;
        for (Drug drug: drugs) {
            if (drug.getName().equalsIgnoreCase(d.getName())) {
                contains = true;
            }
        }
        if (!contains) {
            drugs.add(d);
        }
    }

    // MODIFIES: THIS
    // EFFECTS: remove a drug from drugs, if a drug is not in there, do nothing
    public void removeDrug(String drugName) {
        Drug sameNameAsD = null;
        for (Drug drug: drugs) {
            if (drug.getName().equalsIgnoreCase(drugName)) {
                sameNameAsD = drug;
            }
        }
        drugs.remove(sameNameAsD);

    }

    // REQUIRES: drugs must contain a drug with drugName as name
    // MODIFIES: THIS, drug with drugName as name
    // EFFECTS: update the dose of an existing drug
    public void updateDose(String drugName, String newDose) {
        Drug correctDrug = null;
        for (Drug drug: drugs) {
            if (drug.getName().equalsIgnoreCase(drugName)) {
                correctDrug = drug;
            }
        }
        correctDrug.updateDose(newDose);
    }

    // REQUIRES: drugs must contain a drug with drugName as name
    // MODIFIES: THIS, drug in drugs represented by drugName
    // EFFECTS: update the dose period of an existing drugs
    public void updateInstructions(String drugName, String newInstructions) {
        Drug correctDrug = null;
        for (Drug drug: drugs) {
            if (drug.getName().equalsIgnoreCase(drugName)) {
                correctDrug = drug;
            }
        }
        correctDrug.updateInstructions(newInstructions);
    }


    // EFFECTS: converts a patient to its JSON representation
    // code modelled based on JSONSerializationDemo
    public JSONObject toJson() {
        JSONObject patient = new JSONObject();
        patient.put("name", name);
        patient.put("birthday", birthdayToJson());
        patient.put("drugs", drugsToJson());
        return patient;
    }

    // EFFECTS: converts the patient's list of drugs to its JSON representation
    public JSONArray drugsToJson() {
        JSONArray drugs = new JSONArray();
        for (Drug d: this.drugs) {
            drugs.put(d.toJson());
        }
        return drugs;
    }

    // EFFECTS: converts the patient's birthday to its JSON representation
    public JSONObject birthdayToJson() {
        JSONObject birthday = new JSONObject();
        birthday.put("year", this.birthday.getYear());
        birthday.put("month", this.birthday.getMonthValue());
        birthday.put("day", this.birthday.getDayOfMonth());
        return birthday;
    }

    // getters
    public List<Drug> getDrugs() {
        return drugs;

    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
