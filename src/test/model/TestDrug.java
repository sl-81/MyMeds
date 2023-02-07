package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDrug {

    private Drug d;
    private Drug r;
    private Drug u;
    private Drug g;
    private Drug s;

    @BeforeEach
    public void setUp() {
        d = new Drug("amoxicillin", "500mg", "2 times a day", "pneumonia");
        r = new Drug("clarithromycin", "500mg", "2 times a day", "pneumonia");
        u = new Drug("amoxicillin", "250mg", "2 times a day", "pneumonia");
        g = new Drug("amoxicillin", "500mg", "3 times a day", "pneumonia");
        s = new Drug("amoxicillin", "500mg", "2 times a day", "ear infection");
    }

    @Test
    public void testConstructor () {
        assertEquals("amoxicillin",d.getName());
        assertEquals("500mg", d.getDose());
        assertEquals("2 times a day", d.getInstructions());
        assertEquals("pneumonia", d.getIndication());
        assertEquals("clarithromycin", r.getName());
        assertEquals("500mg", r.getDose());
        assertEquals("2 times a day", r.getInstructions());
        assertEquals("pneumonia", r.getIndication());

    }

    @Test
    public void testUpdateDose() {
        d.updateDose("1000mg");
        assertEquals("1000mg", d.getDose());
        r.updateDose("250mg");
        assertEquals("250mg", r.getDose());
    }


    @Test
    public void testUpdateDoseMultipleTimes() {
        d.updateDose("250mg");
        assertEquals("250mg", d.getDose());
        d.updateDose("500mg");
        assertEquals("500mg", d.getDose());
    }

    @Test
    public void testUpdateInstructions(){
        u.updateInstructions("3 times a day");
        assertEquals("3 times a day", u.getInstructions());
    }

    @Test
    public void testUpdateInstructionsMultipleTimes(){
        u.updateInstructions("3 times a day");
        assertEquals("3 times a day", u.getInstructions());
        u.updateInstructions("twice a week");
        assertEquals("twice a week", u.getInstructions());


    }



    @Test
    public void testCheckIfSameDrug(){
        assertFalse(d.checkIfSameDrug(r));
        assertTrue(d.checkIfSameDrug(u));
    }

    @Test
    public void testDrugEquals() {
        assertFalse(d.equals("amoxicillin"));
        assertTrue(d.equals(new Drug("amoxicillin", "500mg",
                "2 times a day", "pneumonia")));
        assertFalse(d.equals(r));
        assertFalse(d.equals(u));
        assertFalse(d.equals(g));
        assertFalse(d.equals(s));

    }

}