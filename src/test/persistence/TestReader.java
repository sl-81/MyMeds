package persistence;

import model.Patient;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestReader {
    private FileReader test;

    @Test
    void testReadNonExistentFile() {
        test = new FileReader("./data/noSuchFile.json");
        try {
            List<Patient> patients = test.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReadEmptyPatientList() {
        test = new FileReader("./data/testReadEmptyPatientList.json");
        try {
            List<Patient> patients = test.read();
            assertEquals(0, patients.size());
        } catch (IOException e) {
            fail("not supposed to catch IOException");
        }
    }

    @Test
    void testReadPatientListNoDrugs() {
        test = new FileReader("./data/testReadPatientListNoDrugs.json");
        try {
            List<Patient> patients = test.read();
            assertEquals(3, patients.size());
            assertEquals("Harry", patients.get(0).getName());
            assertEquals(LocalDate.of(1980,7,31), patients.get(0).getBirthday());
            assertEquals(0, patients.get(0).getDrugs().size());
            assertEquals("Hermione", patients.get(1).getName());
        } catch (IOException e) {
            fail("not supposed to catch IOException");
        }

    }

    @Test
    void testReadPatientListWithDrugs() {
        test = new FileReader("./data/testReadPatientListDrugs.json");
        try {
            List<Patient> patients = test.read();
            assertEquals(3, patients.size());
            assertEquals("Harry", patients.get(0).getName());
            assertEquals(2, patients.get(0).getDrugs().size());
            assertEquals("Hermione", patients.get(1).getName());
            assertEquals(1, patients.get(1).getDrugs().size());
            assertEquals("Ron", patients.get(2).getName());
            assertEquals(1, patients.get(2).getDrugs().size());
            assertEquals("Amortentia", patients.get(2).getDrugs().get(0).getName());
            assertEquals("Gillyweed", patients.get(0).getDrugs().get(1).getName());

        } catch (IOException e) {
            fail("not supposed to catch IOException");
        }
    }

}
