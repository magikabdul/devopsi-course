package cloud.cholewa.clinic.patient.controller;

import cloud.cholewa.clinic.patient.dto.PatientResponse;
import cloud.cholewa.clinic.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        return ResponseEntity.ok(patientService.fetchAllPatients());
    }

    @GetMapping("/{pesel}")
    public ResponseEntity<PatientResponse> getPatientByPesel(@PathVariable Long pesel) {
        return ResponseEntity.ok(patientService.fetchPatientByPesel(pesel));
    }

}
