package cloud.cholewa.clinic.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPatientRepository extends JpaRepository<PatientEntity, Long> {

    Optional<PatientEntity> findByPesel(String pesel);

}
