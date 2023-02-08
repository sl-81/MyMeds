package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class TestPatient {
    private Patient p;
    private Patient q;
    private Drug am;
    private Drug ce;

    @BeforeEach
    public void setUp(){
        p = new Patient ("Test", 2000,1,1);
        q = new Patient("Test2", 1999,12,31);
        am = new Drug("amoxicillin","500mg","3 times a day","ear infection");
        ce = new Drug("cetirizine","20mg","once a day","allergies");
    }

    @Test
    public void testConstructor() {
        assertEquals("Test",p.getName());
        assertEquals(LocalDate.of(2000,1,1),p.getBirthday());
        assertEquals((LocalDate.now().getYear() - 2000), p.getAge());
        assertEquals(new ArrayList<>(), p.getDrugs());

        assertEquals("Test2", q.getName());
        assertEquals(LocalDate.of(1999,12,31), q.getBirthday());
        assertEquals(new ArrayList<>(), q.getDrugs());
        assertEquals((LocalDate.now().getYear() - 1999), q.getAge());
    }




    // MODIFIES: THIS
    // EFFECTS: add a drug to drugs, if the exact same drug (by name) is in there, do nothing
    @Test
    public void testAddDrug() {
        q.addDrug(am);
        assertEquals(1,q.getDrugs().size());
    }

    @Test
    public void testAddSameDrug() {
        q.addDrug(am);
        assertEquals(1,q.getDrugs().size());
        q.addDrug(am);
        assertEquals(1,q.getDrugs().size());
    }

    @Test
    public void testAddDrugMultipleTimes() {
        q.addDrug(am);
        assertEquals(1,q.getDrugs().size());
        q.addDrug(ce);
        assertEquals(2,q.getDrugs().size());
    }

    // DELETE A DRUG
    // MODIFIES: THIS
    // EFFECTS: remove a drug from drugs, if a drug is not in there, do nothing
    @Test
    public void testRemoveDrug() {
        q.addDrug(am);
        assertEquals(1, q.getDrugs().size());
        q.removeDrug("amoxicillin");
        assertEquals(0,q.getDrugs().size());
    }

    @Test
    public void testRemoveNonExistentDrug(){
        q.removeDrug("cetirizine");
        assertEquals(0,q.getDrugs().size());
        q.addDrug(ce);
        assertEquals(1, q.getDrugs().size());
        q.removeDrug("amoxicillin");
        assertEquals(1, q.getDrugs().size());
    }

    @Test
    public void testRemoveMultipleDrugs(){
        q.addDrug(am);
        q.addDrug(ce);
        assertEquals(2,q.getDrugs().size());
        q.removeDrug("amoxicillin");
        assertEquals(1,q.getDrugs().size());
        ArrayList<Drug> testDrug = new ArrayList<Drug>();
        testDrug.add(ce);
        assertEquals(testDrug,q.getDrugs());
        q.removeDrug("cetirizine");
        assertEquals(0,q.getDrugs().size());
    }

    // REQUIRES: d must be in drugs, newDose >0
    // MODIFIES: THIS, d
    // EFFECTS: update the dose of an existing drug
    @Test
    public void testUpdateDose () {
        q.addDrug(am);
        q.updateDose("amoxicillin", "1000mg");
        ArrayList<Drug> testUpdateDrug = new ArrayList<Drug>();
        Drug testDrug = new Drug("amoxicillin","1000mg", "3 times a day", "ear infection");
        testUpdateDrug.add(testDrug);
        assertEquals(testUpdateDrug, q.getDrugs());

    }

    @Test
    public void testUpdateDoseLongerList () {
        q.addDrug(ce);
        q.addDrug(am);
        q.updateDose("amoxicillin", "1000mg");
        ArrayList<Drug> testUpdateDrug = new ArrayList<Drug>();
        testUpdateDrug.add(ce);
        testUpdateDrug.add(new Drug("amoxicillin","1000mg", "3 times a day", "ear infection"));
        assertEquals(testUpdateDrug, q.getDrugs());
    }

    // REQUIRES: d must be in drugs
    // MODIFIES: THIS
    // EFFECTS: update the dose period of an existing drugs
    @Test
    public void testUpdateInstructions() {
        q.addDrug(am);
        q.updateInstructions("amoxicillin", "once every 2 days");
        ArrayList<Drug> testUpdatePeriod = new ArrayList<Drug>();
        testUpdatePeriod.add(new Drug("amoxicillin","500mg","once every 2 days","ear infection"));
        assertEquals(testUpdatePeriod, q.getDrugs());
    }

    @Test
    public void testUpdateInstructionsLongerList() {
        q.addDrug(ce);
        q.addDrug(am);
        q.updateInstructions("amoxicillin", "twice a day");
        ArrayList<Drug> testUpdatePeriod = new ArrayList<Drug>();
        testUpdatePeriod.add(ce);
        testUpdatePeriod.add(new Drug("amoxicillin","500mg","twice a day","ear infection"));
        assertEquals(testUpdatePeriod, q.getDrugs());
    }


}
