package persistence;

import model.Drug;
import model.Patient;
import model.PatientsRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestWriter {
    private FileWriter test;
    private PatientsRecord testPatients;
    private Patient h;
    private Patient r;

    @BeforeEach
    void setUp() {
        testPatients = new PatientsRecord();
        h = new Patient("Harry", 1980, 7, 31);
        r = new Patient("Ron", 1980, 3, 1);
        testPatients.add(h);
        testPatients.add(r);
    }

    @Test
    void testWriteInvalidFile() {
        test = new FileWriter("./data/non\0ExistentFile.json");
        try {
            test.open();
            fail("should catch IOException");
        } catch (IOException e) {
            //passes
        }

    }

    @Test
    void testWriteEmptyPatientList() {
        try {
            test = new FileWriter("./data/testWriteEmptyPatientList.json");
            testPatients = new PatientsRecord();
            test.open();
            test.write(testPatients);
            test.close();

            FileReader testReader = new FileReader("./data/testWriteEmptyPatientList.json");
            testPatients = testReader.read();
            assertEquals(0, testPatients.getTotalPatientCount());

        } catch (FileNotFoundException e) {
            fail("should not catch FileNotFoundException");
        } catch (IOException e) {
            fail("should not catch IOException");
        }
    }

    @Test
    void testWritePatientList() {
        try {
            test = new FileWriter("./data/testWritePatientList.json");
            test.open();
            test.write(testPatients);
            test.close();

            FileReader testReader = new FileReader("./data/testWritePatientList.json");
            testPatients = testReader.read();
            assertEquals(2, testPatients.getTotalPatientCount());
            assertEquals("Harry", testPatients.getPatientAtIndex(0).getName());

        } catch (FileNotFoundException e) {
            fail("should not catch FileNotFoundException");
        } catch (IOException e) {
            fail("should not catch IOException");
        }
    }


    @Test
    void testWritePatientListWithDrugs() {
        try {
            test = new FileWriter("./data/testWritePatientListWithDrugs.json");
            h.addDrug(new Drug("Felix Felicis", "1 tsp", "every 12 hours", "luck"));
            h.addDrug(new Drug("Gillyweed", "50g", "use before diving", "underwater breathing"));
            test.open();
            test.write(testPatients);
            test.close();

            FileReader testReader = new FileReader("./data/testWritePatientListWithDrugs.json");
            testPatients = testReader.read();
            assertEquals(2, testPatients.getTotalPatientCount());
            assertEquals("Harry", testPatients.getPatientAtIndex(0).getName());
            assertEquals(2, testPatients.getPatientAtIndex(0).getDrugs().size());
            assertEquals(2, testPatients.getPatientAtIndex(0).getDrugs().size());

        } catch (FileNotFoundException e) {
            fail("should not catch FileNotFoundException");
        } catch (IOException e) {
            fail("should not catch IOException");
        }
    }
}
