package cloud.cholewa.clinic.patient.repository;

import cloud.cholewa.clinic.patient.model.Patient;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientRepositoryMapper {

    Patient toDomain(PatientEntity patientEntity);

    @Mapping(target = "id", ignore = true)
    PatientEntity toEntity(Patient patient);

    @IterableMapping(elementTargetType = Patient.class)
    List<Patient> toDomain(List<PatientEntity> patientEntityList);
}
