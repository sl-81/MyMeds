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
    private Condition c;
    private Condition d;
    private Drug am;
    private Drug ce;

    @BeforeEach
    public void setUp(){
        p = new Patient ("Test", 2000,1,1);
        q = new Patient("Test2", 1999,12,31);
        c = new Condition("asthma");
        d = new Condition("depression");
        am = new Drug("amoxicillin",500,"mg","day",3);
        ce = new Drug("cetirizine",20,"mg","day",1);
    }

    @Test
    public void testConstructor() {
        assertEquals("Test",p.getName());
        assertEquals(LocalDate.of(2000,1,1),p.getBirthday());
        assertEquals(new ArrayList<>(), p.getConditions());
        assertEquals(new ArrayList<>(), p.getDrugs());

        assertEquals("Test2", q.getName());
        assertEquals(LocalDate.of(1999,12,31), q.getBirthday());
        assertEquals(new ArrayList<>(), q.getConditions());
        assertEquals(new ArrayList<>(), q.getDrugs());
    }


    // ADD A CONDITION
    // MODIFIES: THIS
    // EFFECTS: adds a condition to conditions, if a condition is already there, do nothing
    @Test
    public void testAddCondition() {
        p.addCondition(c);
        assertEquals(1,p.getConditions().size());
    }

    @Test
    public void testAddSameConditionMultipleTimes(){
        p.addCondition(c);
        assertEquals(1,p.getConditions().size());
        p.addCondition(c);
        assertEquals(1,p.getConditions().size());
        p.addCondition(new Condition("ASTHMA"));
        assertEquals(1,p.getConditions().size());
    }

    @Test
    public void testAddMultipleConditions(){
        p.addCondition(new Condition("heartburn"));
        assertEquals(1,p.getConditions().size());
        p.addCondition(new Condition("anxiety"));
        assertEquals(2,p.getConditions().size());
    }

    // DELETE A CONDITION
    // MODIFIES: THIS
    // EFFECTS: remove a condition from conditions, if a condition is not there, do nothing
    @Test
    public void testRemoveCondition () {
        p.addCondition(d);
        assertEquals(1, p.getConditions().size());
        p.removeCondition(d);
        assertEquals(0,p.getConditions().size());
    }

    @Test
    public void testRemoveNonExistentCondition(){
        p.removeCondition(d);
        assertEquals(0,p.getConditions().size());
        p.addCondition(d);
        assertEquals(1, p.getConditions().size());
        p.removeCondition(c);
        assertEquals(1, p.getConditions().size());
    }

    @Test
    public void testRemoveMultipleConditions(){
        p.addCondition(c);
        p.addCondition(d);
        assertEquals(2, p.getConditions().size());
        p.removeCondition(c);
        assertEquals(1, p.getConditions().size());
        ArrayList<Condition> testConditions = new ArrayList<Condition>();
        testConditions.add(d);
        assertEquals(testConditions,p.getConditions());
        p.removeCondition(d);
        assertEquals(0, p.getConditions().size());
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
        q.removeDrug(new Drug("amoxicillin",1000,"mg","day",3));
        assertEquals(0,q.getDrugs().size());
    }

    @Test
    public void testRemoveNonExistentDrug(){
        q.removeDrug(ce);
        assertEquals(0,q.getDrugs().size());
        q.addDrug(ce);
        assertEquals(1, q.getDrugs().size());
        q.removeDrug(am);
        assertEquals(1, q.getDrugs().size());
    }

    @Test
    public void testRemoveMultipleDrugs(){
        q.addDrug(am);
        q.addDrug(ce);
        assertEquals(2,q.getDrugs().size());
        q.removeDrug(am);
        assertEquals(1,q.getDrugs().size());
        ArrayList<Drug> testDrug = new ArrayList<Drug>();
        testDrug.add(ce);
        assertEquals(testDrug,q.getDrugs());
        q.removeDrug(ce);
        assertEquals(0,q.getDrugs().size());
    }

    // REQUIRES: d must be in drugs, newDose >0
    // MODIFIES: THIS, d
    // EFFECTS: update the dose of an existing drug
    @Test
    public void testUpdateDose () {
        q.addDrug(am);
        q.updateDose(am, 1000);
        ArrayList<Drug> testUpdateDrug = new ArrayList<Drug>();
        Drug testDrug = new Drug("amoxicillin",1000,"mg","day",3);
        testUpdateDrug.add(testDrug);
        assertEquals(testUpdateDrug, q.getDrugs());

    }

    @Test
    public void testUpdateDoseLongerList () {
        q.addDrug(ce);
        q.addDrug(am);
        q.updateDose(am, 1000);
        ArrayList<Drug> testUpdateDrug = new ArrayList<Drug>();
        testUpdateDrug.add(ce);
        testUpdateDrug.add(new Drug("amoxicillin",1000,"mg","day",3));
        assertEquals(testUpdateDrug, q.getDrugs());
    }

    // REQUIRES: d must be in drugs
    // MODIFIES: THIS
    // EFFECTS: update the dose period of an existing drugs
    @Test
    public void testUpdatePeriod() {
        q.addDrug(am);
        q.updatePeriod(am, "2 days");
        ArrayList<Drug> testUpdatePeriod = new ArrayList<Drug>();
        testUpdatePeriod.add(new Drug("amoxicillin",500,"mg","2 days",3));
        assertEquals(testUpdatePeriod, q.getDrugs());
    }

    @Test
    public void testUpdatePeriodLongerList() {
        q.addDrug(ce);
        q.addDrug(am);
        q.updatePeriod(am, "2 days");
        ArrayList<Drug> testUpdatePeriod = new ArrayList<Drug>();
        testUpdatePeriod.add(ce);
        testUpdatePeriod.add(new Drug("amoxicillin",500,"mg","2 days",3));
        assertEquals(testUpdatePeriod, q.getDrugs());
    }

    // REQUIRES: d must be in drugs
    // MODIFIES: THIS, d
    // EFFECTS: update the frequency of an existing drug in the list
    @Test
    public void testUpdateFrequency() {
        q.addDrug(am);
        q.updateFrequency(am, 2);
        ArrayList<Drug> testUpdateFreq = new ArrayList<Drug>();
        testUpdateFreq.add(new Drug("amoxicillin",500,"mg","day",2));
        assertEquals(testUpdateFreq, q.getDrugs());
    }

    @Test
    public void testUpdateFrequencyLongerList() {
        q.addDrug(ce);
        q.addDrug(am);
        q.updateFrequency(am, 4);
        ArrayList<Drug> testUpdateFreq = new ArrayList<Drug>();
        testUpdateFreq.add(ce);
        testUpdateFreq.add(new Drug("amoxicillin",500,"mg","day",4));
        assertEquals(testUpdateFreq, q.getDrugs());
    }

}
