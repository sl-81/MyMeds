package model;

// Represents a drug with a unique name, a dose (eg 10mg), a string representing the instructions and a string
// representing the indication of the drug
// eg. new Drug("venlafaxine", "150mg", "once daily", anxiety)
//     declares a new drug named venlafaxine for which 150 mg is to be taken 1 time a day for anxiety

import java.util.Objects;

public class Drug {
    private String name;
    private String dose;
    private String instructions;
    private String indication;

    // EFFECTS: creates a new drug with a name, dose, a set of instructions and its indication
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

    // MODIFIES: THIS
    // EFFECTS: updates the instructions of the drugs
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


    // EFFECTS: check if 2 drugs have equivalent fields
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Drug)) {
            return false;
        }
        Drug drug = (Drug) o;
        return getName().equals(drug.getName()) && getDose().equals(drug.getDose())
                && getInstructions().equals(drug.getInstructions()) && getIndication().equals(drug.getIndication());
    }

}
