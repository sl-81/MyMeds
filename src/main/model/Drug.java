package model;

// Represents a drug with a unique name, a dose, a unit (eg mg, mcg, mg/ml etc)
// a date period representing usage (eg day, 2 days, week),
// and an integer frequency representing how often they take it within the period.
// eg. new Drug("venlafaxine", "150", "mg", "day", "1")
//     declares a new drug named venlafaxine for which 150 mg is to be taken 1 time a day

import java.util.Objects;

public class Drug {
    private String name;
    private String dose;
    private String instructions;
    private String indication;

    // CONSTRUCTOR, CREATES A NEW DRUG GIVEN NAME, DOSE, MEASURING-UNIT(mg, mcg, g), DOSE UNIT, FREQUENCY
    public Drug(String name, String dose, String instructions, String indication) {
        this.name = name;
        this.dose = dose;
        this.instructions = instructions;
        this.indication = indication;
    }

    // MODIFIES: THIS
    // EFFECTS: updates the dose of the drug
    public void updateDose(String newDose) {

        this.dose = newDose;
    }

    // FOR WHEN PATIENT NEED TO REDUCE/INCREASE PERIOD(EG FROM EVERY DAY TO EVERY OTHER DAY)
    // REQUIRES: String must be a valid time period (eg. day, 2 days, week, month)
    // MODIFIES: THIS
    // EFFECTS: updates the period of the drug
    public void updateInstructions(String newInstructions) {
        this.instructions = newInstructions;
    }


    // EFFECTS: if this and d has the same name, they are the same drug so return true, otherwise return false
    public boolean checkIfSameDrug(Drug d) {

        return this.name.equalsIgnoreCase(d.getName());
    }

    public String getName() {

        return this.name;
    }

    public String getDose() {

        return this.dose;
    }


    public String getInstructions() {
        return this.instructions;
    }

    public String getIndication() {
        return this.indication;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drug)) return false;
        Drug drug = (Drug) o;
        return getName().equals(drug.getName()) && getDose().equals(drug.getDose()) && getInstructions().equals(drug.getInstructions()) && getIndication().equals(drug.getIndication());
    }

}
