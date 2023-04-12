# MyMeds

## *A platform to store individuals' medical conditions and the medications that they take.*

*Designed for people with multiple medications and conditions so that they can quickly access their medical information. Also useful if one person has to manage medications for the whole family.*

*Upon launching the app, the user will be able to view a list of people stored in the app and has the option to view a patient or add a new patient. If a patient is selected, user can view their age (auto-updates upon launching app), conditions and there will be an option to view their medications and user may select it to display all the medications for that patient.*

## User Stories:
- As a user, I want to be able to add a person to keep track of with their name and birthday as identifier
- As a user, I want to be able to stop keeping track of a patient and remove them from the interface
- As a user, I want to be able to add a drug to a patient's chart by entering the drug's name, dosage, and instructions.
- As a user, I want to be able to update the dose of an existing drug.
- As a user, I want to be able to update the instructions of an existing drug.
- As a user, I want to be able to remove a discontinued drug from a patient's profile.
- As a user, I want to be able to save any changes I've made to the patient list/drug list at any time.
- As a user, I want to be able to load my last saved profile at any time.

## Instructions for Grader:
- You can add a patient to your list by clicking on the "Add a patient" button on the main page then entering their name and birthday
- You can remove a patient from your list by clicking on the "Remove a patient" on the main page then selecting the patient's name from the dropdown menu
- You can view a patient by selecting their name from the dropdown menu on the main page
- You can add a drug to a patient's medication list by selecting a patient to view from the dropdown menu on the main page, then click on the "Add a drug" button from the patient's info page
- You can remove a drug from a patient's medication list by selecting a patient to view from the dropdown menu on the main page, then click on the "Remove a drug" button from the patient's info page, then select the drug to remove from the dropdown menu that appears
- You can generate a barchart showing each patient and the number of drugs they take by clicking on the "Display Patient Drug Graph" button on the main page.
- You can save your current list by clicking on the "Save current data" button on the main page
- You can load your previously saved list by clicking on the "Load last saved data" button on the main page

## Phase 4: Task 2:
- Tue Apr 11 20:36:37 PDT 2023
- Added patient x to record.
- Tue Apr 11 20:36:43 PDT 2023
- Saved file.
- Tue Apr 11 20:36:45 PDT 2023
- Removed patient x from record.
- Tue Apr 11 20:36:47 PDT 2023
- Loading previously saved file...
- Tue Apr 11 20:36:47 PDT 2023
- Added patient x to record.
- Tue Apr 11 20:36:47 PDT 2023
- Successfully loaded previously saved file.
- Tue Apr 11 20:37:00 PDT 2023
- drug x is added to patient x's file.
- Tue Apr 11 20:37:09 PDT 2023
- drug x is removed from patient x's file.
- Tue Apr 11 20:37:13 PDT 2023
- Removed patient x from record.
- Tue Apr 11 20:37:15 PDT 2023
- Saved file.

## Phase 4: Task 3:
- Since Patient class only has one list of drugs, I can also make Patient implement Iterable<Drug> and directly loop through a patient.
- I can also make use of the observer pattern and make patients and selectedPatient the subject and ui an observer, that way instead of calling runMyMeds() everytime I can just call ui.update() whenever an add/remove function happens in the subjects
- The function runMyMeds() can be refactored into parts (initialize panel, set patientDirectory, set menu etc...) for ease of understanding.
- In the function generateGraph(), the initiation of the list and adding data to the list can be refactored into a function called initializeGraphData() for ease of understanding, another way of doing this would be converting the two lists into a hashmap with patients' names as key, so the BarChart class only needs a hashmap variable rather than 2 lists and simplifies the fields in the BarChart class by a little and the paintComponent() method in the BarChart will also be more readable as we can use a for-each loop to loop through the keys in the hashmap rather than a for loop, this will lose the order in which patients are added but is otherwise a good approach.
