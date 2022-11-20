package Domain;


import java.util.Date;
import java.util.Objects;

public class Patient implements Identifiable<Integer>, Comparable<Patient> {
    private String firstname;
    private String surname;
    private Date appointmentDate;
    private  int PatientId;

    @Override
    public Integer getId() {
        return this.PatientId;
    }

    @Override
    public void setID(Integer id) {
        PatientId = id;
    }

    public Patient(String firstname, String surname, Date appointmentDate, int patientId) {
        this.firstname = firstname;
        this.surname = surname;
        this.appointmentDate = appointmentDate;
        PatientId = patientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", PatientId=" + PatientId +
                '}';
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return PatientId == patient.PatientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PatientId);
    }

    @Override
    public int compareTo(Patient o) {
        return this.appointmentDate.compareTo(o.getAppointmentDate());
    }
}
