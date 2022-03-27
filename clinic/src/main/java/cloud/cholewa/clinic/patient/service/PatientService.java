package cloud.cholewa.clinic.patient.service;

import cloud.cholewa.clinic.patient.dto.PatientRequest;
import cloud.cholewa.clinic.patient.dto.PatientResponse;

import java.util.List;

public interface PatientService {

    List<PatientResponse> fetchAllPatients();

    PatientResponse fetchPatientByPesel(String pesel);

    PatientResponse registerPatient(PatientRequest patientRequest);

    void deletePatientByPesel(String pesel);
}
