package cloud.cholewa.clinic.patient.repository;

import cloud.cholewa.clinic.patient.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryPatientRepository implements PatientRepository {

    private final HashMap<String, Patient> patients = new HashMap<>();

    @Override
    public List<Patient> findAllPatients() {
        return patients.values().stream().toList();
    }

    @Override
    public Optional<Patient> findPatientByPesel(String pesel) {
        return Optional.ofNullable(patients.get(pesel));
    }

    @Override
    public Patient savePatient(Patient patient) {
        patients.put(patient.getPesel(), patient);
        return patients.get(patient.getPesel());
    }
}
