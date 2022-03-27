package cloud.cholewa.clinic.patient.controller;

import cloud.cholewa.clinic.patient.dto.PatientRequest;
import cloud.cholewa.clinic.patient.dto.PatientResponse;
import cloud.cholewa.clinic.patient.dto.UpdatePatientRequest;
import cloud.cholewa.clinic.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public ResponseEntity<PatientResponse> getPatientByPesel(@PathVariable String pesel) {
        return ResponseEntity.ok(patientService.fetchPatientByPesel(pesel));
    }

    @PostMapping
    public ResponseEntity<PatientResponse> registerPatient(@Valid @RequestBody PatientRequest patientRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.registerPatient(patientRequest));
    }

    @DeleteMapping("/{pesel}")
    public ResponseEntity<Void> deletePatient(@PathVariable String pesel) {
        patientService.deletePatientByPesel(pesel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{pesel}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable String pesel, @Valid @RequestBody UpdatePatientRequest updatePatientRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(patientService.updatePatient(pesel, updatePatientRequest));
    }
}
