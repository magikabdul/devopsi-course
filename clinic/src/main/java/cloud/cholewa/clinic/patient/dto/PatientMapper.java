package cloud.cholewa.clinic.patient.dto;

import cloud.cholewa.clinic.patient.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientResponse mapToPatientResponse(Patient patient);
}
