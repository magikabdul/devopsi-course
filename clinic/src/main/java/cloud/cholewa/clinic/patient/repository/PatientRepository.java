package cloud.cholewa.clinic.patient.repository;

import cloud.cholewa.clinic.patient.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {

    List<Patient> findAllPatients();

    Optional<Patient> findPatientByPesel(String pesel);

    Patient savePatient (Patient patient);

    void removePatient(Patient patient);
}
