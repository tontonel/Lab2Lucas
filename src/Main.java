import Persistancy.Repository;
import Domain.Patient;
import Utils.DateFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import Service.Service;

import static UI.UI.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        ArrayList<Patient> patientsList = new ArrayList<>();
        patientsList.add(new Patient("Ionut", "Pop", new DateFormatter("12 10 12").getDate(), 1));
        patientsList.add(new Patient("Mihai", "Luca", new DateFormatter("12 10 13").getDate(), 2));
        patientsList.add(new Patient("Andrei", "Mihaila", new DateFormatter("13 10 13").getDate(), 3));
        Repository<Patient> repo = new Repository<>(patientsList);
        Service patientService = new Service(repo);

        while(true) {
            try {
                int command = readCommand();
                if (command == 1)
                    printRepo(patientService.getAll());
                else if(command == 2) {
                    Patient patient = readPatient();
                    patientService.addPatient(patient);
                }
                else if(command == 3) {
                    int id = readID();
                    patientService.deletePatient(id);
                }
                else if(command == 4) {
                    int id = readID();
                    Patient patient = readPatient();
                    patientService.updatePatient(id, patient);
                }
                else if(command == 5) {
                    Date date = readDate();
                    printRepo(patientService.getAppointmentsForOneDay(date));
                }
                else if(command == 6)
                    printRepo(patientService.sortAfterDate());
                else if(command == 0)
                    break;
            } catch (Exception err) {
                printErr(err);
            }
        }
    }
}