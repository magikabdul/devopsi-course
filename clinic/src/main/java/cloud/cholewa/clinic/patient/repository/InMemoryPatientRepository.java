package cloud.cholewa.clinic.patient.repository;

import cloud.cholewa.clinic.patient.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryPatientRepository implements PatientRepository {

    private final HashMap<Long, Patient> patiens = new HashMap<>();

    @Override
    public List<Patient> findAllPatients() {
        return patiens.values().stream().toList();
    }

    @Override
    public Optional<Patient> findPatientByPesel(Long pesel) {
        return Optional.ofNullable(patiens.get(pesel));
    }
}
