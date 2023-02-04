package model;

// Represents a drug with a unique name, a dose, a unit (eg mg, mcg, mg/ml etc)
// a date period representing usage (eg day, 2 days, week),
// and an integer frequency representing how often they take it within the period.
// eg. new Drug("venlafaxine", "150", "mg", "day", "1")
//     declares a new drug named venlafaxine for which 150 mg is to be taken 1 time a day

import java.util.Objects;

public class Drug {
    private String name;
    private double dose;
    private String unit;
    private String period;
    private int frequency;

    // CONSTRUCTOR, CREATES A NEW DRUG GIVEN NAME, DOSE, MEASURING-UNIT(mg, mcg, g), DOSE UNIT, FREQUENCY
    public Drug(String name, double dose, String unit, String period, int frequency) {
        this.name = name;
        this.dose = dose;
        this.unit = unit;
        this.period = period;
        this.frequency = frequency;
    }

    // MODIFIES: THIS
    // EFFECTS: updates the dose of the drug
    public void updateDose(double newDose) {
        this.dose = newDose;
    }

    // FOR WHEN PATIENT NEED TO REDUCE/INCREASE PERIOD(EG FROM EVERY DAY TO EVERY OTHER DAY)
    // REQUIRES: String must be a valid time period (eg. day, 2 days, week, month)
    // MODIFIES: THIS
    // EFFECTS: updates the period of the drug
    public void updatePeriod(String newPeriod) {
        this.period = newPeriod;
    }

    // REQUIRE: newFrequency > 0
    // MODIFIES: THIS
    // EFFECTS: updates the frequency of the drug
    public void updateFrequency(int newFrequency) {
        this.frequency = newFrequency;
    }

    // EFFECTS: if this and d has the same name, they are the same drug so return true, otherwise return false
    public boolean checkIfSameDrug(Drug d) {

        return this.name.equalsIgnoreCase(d.getName());
    }

    public String getName() {

        return this.name;
    }

    public double getDose() {

        return this.dose;
    }


    public String getUnit() {

        return this.unit;
    }

    public String getPeriod() {

        return this.period;
    }

    public int getFrequency() {

        return this.frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Drug)) {
            return false;
        }
        Drug drug = (Drug) o;
        return getFrequency() == drug.getFrequency() && getName().equals(drug.getName()) && getDose()
                == (drug.getDose()) && getUnit().equals(drug.getUnit()) && getPeriod().equals(drug.getPeriod());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDose(), getUnit(), getPeriod(), getFrequency());
    }
}
