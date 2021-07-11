package peker.software.esh_agenda_backend.dtoConvertor;


import org.springframework.stereotype.Component;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.entities.Patient;

@Component
public class PatientDtoConvertor {

    public Patient convert(PatientDto from) {

        Patient patient = new Patient(
                from.getId(),
                from.getPatientNumber(),
                from.getFirstName(),
                from.getLastName(),
                from.getNationalIdentityNumber(),
                from.getSex(),
                from.getMumName(),
                from.getDadName(),
                from.getBirthDayOfPatient(),
                from.getAge(),
                from.getPlaceOfBirth(),
                from.getIsActive(),
                from.getCurrentStateOfPatient(),
                from.getCreatedDate(),
                null
        );

        if (from.getUpdatedDate() != null) {
            patient.setUpdatedDate(from.getUpdatedDate());
        }

        return patient;
    }

    public PatientDto convert(Patient from) {

        PatientDto patientDto = new PatientDto(
                from.getId(),
                from.getPatientNumber(),
                from.getFirstName(),
                from.getLastName(),
                from.getNationalIdentityNumber(),
                from.getSex(),
                from.getMumName(),
                from.getDadName(),
                from.getBirthDayOfPatient(),
                from.getAge(),
                from.getPlaceOfBirth(),
                from.getIsActive(),
                from.getCurrentStateOfPatient(),
                from.getCreatedDate(),
                null
        );

        if (from.getUpdatedDate() != null) {
            patientDto.setUpdatedDate(from.getUpdatedDate());
        }

        return patientDto;
    }
}
