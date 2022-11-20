package Service;
import Persistancy.Repository;
import Domain.Patient;
import Utils.DateUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import Exception.*;

public class Service {
    private Repository _repo;

    public Service(Repository _repo) {
        this._repo = _repo;
    }

    public ArrayList<Patient> getAppointmentsForOneDay(Date date) {
        ArrayList<Patient> patients = new ArrayList<>();
        for(Object patient : _repo.getAll()) {
            Patient casted_patient = (Patient)patient;
            if(DateUtils.isSameDay(casted_patient.getAppointmentDate(), date))
                patients.add(casted_patient);
        }
        return patients;
    }

    public void addPatient(Patient patient) throws NoIdenticEntitiesException, AppointmentException {
        for(Object p : _repo){
            if(((Patient) p).getAppointmentDate().equals(patient.getAppointmentDate()))
                throw new AppointmentException();
        }
        _repo.addEntity(patient);
    }

    public void updatePatient(int id, Patient patient) throws NoEntityFound {
        _repo.updateEntity(id, patient);
    }

    public Patient deletePatient(int id) {
        return (Patient) _repo.deleteEntity(id);
    }

    public ArrayList<Patient> getAll() {
        return _repo.getAll();
    }

    public ArrayList<Patient> sortAfterDate() {
        ArrayList<Patient> patients = _repo.getAll();
        Collections.sort(patients);
        return patients;

    }

}
