package persistence;

import model.Patient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

// code borrowed from JSONSerializationDemo
public class FileWriter {
    private PrintWriter writer;
    private String destination;

    //EFFECTS: constructs writer to write to destination file
    public FileWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of patient list to file
    public void write(List<Patient> patients) {
        JSONObject finalFile = new JSONObject();
        JSONArray patientList = new JSONArray();
        for (Patient p: patients) {
            patientList.put(p.toJson());
        }
        finalFile.put("patient", patientList);
        saveToFile(finalFile.toString(4));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String file) {
        writer.print(file);
    }
}
