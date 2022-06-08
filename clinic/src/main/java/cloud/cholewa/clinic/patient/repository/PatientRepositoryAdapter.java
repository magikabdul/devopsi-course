package cloud.cholewa.clinic.patient.repository;

import cloud.cholewa.clinic.patient.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PatientRepositoryAdapter implements PatientRepository {

    private final JpaPatientRepository repository;
    private final PatientRepositoryMapper mapper;

    @Override
    public List<Patient> findAllPatients() {
        return mapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Patient> findPatientByPesel(String pesel) {
        var patientByPesel = repository.findByPesel(pesel);

        if (patientByPesel.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(mapper.toDomain(patientByPesel.get()));
    }

    @Override
    public Patient savePatient(Patient patient) {
        var savedPatient = repository.save(mapper.toEntity(patient));
        return mapper.toDomain(savedPatient);
    }

    @Override
    public void removePatient(Patient patient) {
        var patientToDelete = repository.findByPesel(patient.getPesel());
        patientToDelete.ifPresent(repository::delete);
    }
}
