package model;

import java.time.LocalDateTime;
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
    // REQUIRES: year must be =< 130 from current year, month must be =< 12
    // day must be =<31 for months = 1,3,5,7,8,10,12, =<3- for months = 4,6,9,11,
    // =<28 for months=2 and not leap year, =<29 for months=2 and leap year
    // EFFECTS: CREATES A NEW PATIENT
    public Patient(String name, int year, int month, int day) {
        this.name = name;
        this.birthday = LocalDate.of(year, month, day);
        this.age = LocalDate.now().getYear() - year;
        this.drugs = new ArrayList<>();
    }


    // EFFECTS: return a list of drugs
    public List<Drug> getDrugs() {
        return drugs;

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

    // REQUIRES: d must be in drugs, newDose >0
    // MODIFIES: THIS, d
    // EFFECTS: update the dose of an existing drug
    public void updateDose(Drug d, String newDose) {
        Drug correctDrug = null;
        for (Drug drug: drugs) {
            if (drug.getName().equalsIgnoreCase(d.getName())) {
                correctDrug = drug;
            }
        }
        correctDrug.updateDose(newDose);
    }

    // REQUIRES: d must be in drugs
    // MODIFIES: THIS
    // EFFECTS: update the dose period of an existing drugs
    public void updateInstructions(Drug d, String newInstructions) {
        for (Drug drug: drugs) {
            if (drug.getName().equalsIgnoreCase(d.getName())) {
                drug.updateInstructions(newInstructions);
            }
        }

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
