package cloud.cholewa.clinic.patient.service;

import cloud.cholewa.clinic.patient.dto.PatientMapper;
import cloud.cholewa.clinic.patient.dto.PatientResponse;
import cloud.cholewa.clinic.patient.exception.PatientException;
import cloud.cholewa.clinic.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public List<PatientResponse> fetchAllPatients() {
        return patientRepository.findAllPatients().stream()
                .map(patientMapper::mapToPatientResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PatientResponse fetchPatientByPesel(Long pesel) {
        return patientRepository
                .findPatientByPesel(pesel)
                .map(patientMapper::mapToPatientResponse)
                .orElseThrow(() -> new PatientException("Provided pesel number not exists"));
    }
}
