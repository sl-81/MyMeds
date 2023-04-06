package persistence;

import model.Event;
import model.EventLog;
import model.Patient;
import model.PatientsRecord;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

// represents a writer that writes the JSON representation of a list of patients to file
// open,close and savefile from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
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
        writer = new PrintWriter(destination);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of patient list to file
    public void write(PatientsRecord patients) {
        JSONObject finalFile = new JSONObject();
        JSONArray patientList = new JSONArray();
        for (Patient p: patients) {
            patientList.put(p.toJson());
        }
        finalFile.put("patient", patientList);
        saveToFile(finalFile.toString(4));
        EventLog.getInstance().logEvent(new Event("Saved file."));
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
