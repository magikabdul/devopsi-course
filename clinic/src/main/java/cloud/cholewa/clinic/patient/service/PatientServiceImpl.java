package cloud.cholewa.clinic.patient.service;

import cloud.cholewa.clinic.patient.dto.PatientMapper;
import cloud.cholewa.clinic.patient.dto.PatientRequest;
import cloud.cholewa.clinic.patient.dto.PatientResponse;
import cloud.cholewa.clinic.patient.dto.UpdatePatientRequest;
import cloud.cholewa.clinic.patient.exception.PatientException;
import cloud.cholewa.clinic.patient.model.Patient;
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
    public PatientResponse fetchPatientByPesel(String pesel) {
        return patientMapper.mapToPatientResponse(findPatientByPesel(pesel));
    }

    @Override
    public PatientResponse registerPatient(PatientRequest patientRequest) {
        if (patientRepository.findPatientByPesel(patientRequest.getPesel()).isPresent()) {
            throw new PatientException("Cant add new patients. Pesel exist in database");
        }

        return patientMapper.mapToPatientResponse(
                patientRepository.savePatient(
                        patientMapper.mapToPatient(patientRequest)
                ));
    }

    @Override
    public void deletePatientByPesel(String pesel) {
        patientRepository.removePatient(findPatientByPesel(pesel));
    }

    @Override
    public PatientResponse updatePatient(String pesel, UpdatePatientRequest updatePatientRequest) {
        Patient patient = findPatientByPesel(pesel);
        patient.setFirstName(updatePatientRequest.getFirstName());
        patient.setLastName(updatePatientRequest.getLastName());
        patient.setPhone(updatePatientRequest.getPhone());
        patient.setDetails(updatePatientRequest.getDetails());

        return patientMapper.mapToPatientResponse(patientRepository.savePatient(patient));
    }

    private Patient findPatientByPesel(String pesel) {
        return patientRepository.findPatientByPesel(pesel)
                .orElseThrow(() -> new PatientException("Provided pesel number not exists"));
    }
}
