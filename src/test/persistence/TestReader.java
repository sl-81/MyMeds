package persistence;

import model.Patient;
import model.PatientsRecord;
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
            PatientsRecord patients = test.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReadEmptyPatientList() {
        test = new FileReader("./data/testReadEmptyPatientList.json");
        try {
            PatientsRecord patients = test.read();
            assertEquals(0, patients.getTotalPatientCount());
        } catch (IOException e) {
            fail("not supposed to catch IOException");
        }
    }

    @Test
    void testReadPatientListNoDrugs() {
        test = new FileReader("./data/testReadPatientListNoDrugs.json");
        try {
            PatientsRecord patients = test.read();
            assertEquals(3, patients.getTotalPatientCount());
            assertEquals("Harry", patients.getPatientAtIndex(0).getName());
            assertEquals(LocalDate.of(1980,7,31), patients.getPatientAtIndex(0).getBirthday());
            assertEquals(0, patients.getPatientAtIndex(0).getDrugs().size());
            assertEquals("Hermione", patients.getPatientAtIndex(1).getName());
        } catch (IOException e) {
            fail("not supposed to catch IOException");
        }

    }

    @Test
    void testReadPatientListWithDrugs() {
        test = new FileReader("./data/testReadPatientListDrugs.json");
        try {
            PatientsRecord patients = test.read();
            assertEquals(3, patients.getTotalPatientCount());
            assertEquals("Harry", patients.getPatientAtIndex(0).getName());
            assertEquals(2, patients.getPatientAtIndex(0).getDrugs().size());
            assertEquals("Hermione", patients.getPatientAtIndex(1).getName());
            assertEquals(1, patients.getPatientAtIndex(1).getDrugs().size());
            assertEquals("Ron", patients.getPatientAtIndex(2).getName());
            assertEquals(1, patients.getPatientAtIndex(2).getDrugs().size());
            assertEquals("Amortentia", patients.getPatientAtIndex(2).getDrugs().get(0).getName());
            assertEquals("Gillyweed", patients.getPatientAtIndex(0).getDrugs().get(1).getName());

        } catch (IOException e) {
            fail("not supposed to catch IOException");
        }
    }

}
