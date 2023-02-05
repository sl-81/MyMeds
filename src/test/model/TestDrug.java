package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDrug {
    // delete or rename this class!
    private Drug d;
    private Drug e;
    private Drug f;

    @BeforeEach
    public void setUp() {
        d = new Drug ("Test", 99, "mg", "day", 1);
        e = new Drug ("Test2", 1, "kg", "week", 3);
        f = new Drug ("Test", 50, "mg", "day", 1);
    }

    @Test
    public void testConstructor () {
        assertEquals("Test", d.getName());
        assertEquals(99, d.getDose());
        assertEquals("mg", d.getUnit());
        assertEquals("day", d.getPeriod());
        assertEquals(1, d.getFrequency());
        assertEquals("Test2", e.getName());
        assertEquals(1, e.getDose());
        assertEquals("kg", e.getUnit());
        assertEquals("week", e.getPeriod());
        assertEquals(3, e.getFrequency());
    }

    @Test
    public void testUpdateDose() {
        d.updateDose(100);
        assertEquals(100, d.getDose());
    }

    @Test
    public void testUpdateDoseWithDouble() {
        e.updateDose(0.1);
        assertEquals(0.1, e.getDose());
    }

    @Test
    public void testUpdateDoseMultipleTimes() {
        d.updateDose(20);
        assertEquals(20,d.getDose());
        d.updateDose(9);
        assertEquals(9,d.getDose());
    }

    @Test
    public void testUpdatePeriod(){
        d.updatePeriod("2 days");
        assertEquals("2 days", d.getPeriod());
    }

    @Test
    public void testUpdatePeriodMultipleTimes(){
        e.updatePeriod("day");
        assertEquals("day", e.getPeriod());
        e.updatePeriod("2 weeks");
        assertEquals("2 weeks", e.getPeriod());
    }

    // FOR WHEN PEOPLE NEED TO CHANGE FREQUENCY (EG FROM ONCE DAILY TO TWICE DAILY)
    // MODIFIES: THIS
    // EFFECTS: updates the frequency of the drug
    @Test
    public void testUpdateFrequency(){
        d.updateFrequency(2);
        assertEquals(2,d.getFrequency());
        e.updateFrequency(1);
        assertEquals(1,e.getFrequency());
    }

    // EFFECTS: return true d is the same drug as THIS, false otherwise
    @Test
    public void testCheckIfSameDrug(){
        assertFalse(d.checkIfSameDrug(e));
        assertTrue(d.checkIfSameDrug(f));
    }

    @Test
    public void testDrugEquals() {
        //comparing drug with other non-drug object should produce false
        assertFalse(e.equals(new Patient("testDrug",1999,11,11)));
        // comparing this with another drug object with same field values should produce true
        assertTrue(d.equals(new Drug ("Test", 99, "mg", "day", 1)));
        // comparing this with drug object that is otherwise same but different dose should produce false
        assertFalse(d.equals(f));
        // comparing this with drug object that is otherwise same but different unit would produce false
        assertFalse(d.equals(new Drug ("Test", 99, "mcg", "day", 1)));
        // comparing this with drug that is otherwise same but different time period would produce false
        assertFalse(d.equals((new Drug ("Test", 99, "mg", "week", 1))));
        // comparing this with drug that is otherwise same but different frequency would produce false
        assertFalse(d.equals((new Drug ("Test", 99, "mg", "day", 3))));
        // comparing this with drug that is otherwise same but different name would produce false
        assertFalse(d.equals(new Drug ("diffTest", 99, "mg", "day", 1)));
    }

}