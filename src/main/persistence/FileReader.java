package persistence;

import model.Drug;
import model.Patient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


// represents a reader that reads the JSON representation of a list of patients to a list of patients
// code modelled from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class FileReader {

    private String location;

    public FileReader(String location) {
        this.location = location;
    }

    // EFFECTS: constructs a new reader, reads a list of patients from the stored location and returns it
    public List<Patient> read() throws IOException {
        String jsonData = readFile(location);
        JSONObject file = new JSONObject(jsonData);
        return parseList(file);
    }

    // method copied from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses a list of patients from the file and return the list
    public List<Patient> parseList(JSONObject rawFile) {
        List<Patient> patients = new ArrayList<>();
        JSONArray patientsJson = rawFile.getJSONArray("patient");
        for (Object pj: patientsJson) {
            JSONObject nextPatient = (JSONObject) pj;
            addToPatientList(patients, nextPatient);
        }
        return patients;
    }

    // EFFECTS: parse a patient from its JSON representation and add it to the patients list
    public void addToPatientList(List<Patient> patients, JSONObject rawPatient) {
        String name = rawPatient.getString("name");
        JSONObject rawBirthday = rawPatient.getJSONObject("birthday");
        int year = rawBirthday.getInt("year");
        int month = rawBirthday.getInt("month");
        int day = rawBirthday.getInt("day");
        Patient p = new Patient(name, year, month, day);
        JSONArray drugsJson = rawPatient.getJSONArray("drugs");
        for (Object dj: drugsJson) {
            JSONObject nextDrug = (JSONObject) dj;
            addToDrugList(p, nextDrug);
        }
        patients.add(p);
    }

    // EFFECTS: parse a drug from its JSON representation and add it to the patient's drug list
    public void addToDrugList(Patient p, JSONObject rawDrug) {
        String name = rawDrug.getString("name");
        String dose = rawDrug.getString("dose");
        String instructions = rawDrug.getString("instructions");
        String indication = rawDrug.getString("indication");
        Drug d = new Drug(name,dose,instructions,indication);
        p.addDrug(d);
    }
}
