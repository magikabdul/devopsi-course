package cloud.cholewa.clinic.patient.service;

import cloud.cholewa.clinic.patient.dto.PatientResponse;

import java.util.List;

public interface PatientService {

    List<PatientResponse> fetchAllPatients();

    PatientResponse fetchPatientByPesel(Long pesel);
}
