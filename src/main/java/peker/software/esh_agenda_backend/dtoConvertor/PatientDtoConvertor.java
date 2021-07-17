package peker.software.esh_agenda_backend.dtoConvertor;


import org.springframework.stereotype.Component;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.entities.Patient;

import java.util.stream.Collectors;

@Component
public class PatientDtoConvertor {

    private final CityDtoConvertor cityDtoConvertor;
    private final PhoneNumberDtoConvertor phoneNumberDtoConvertor;

    public PatientDtoConvertor(CityDtoConvertor cityDtoConvertor, PhoneNumberDtoConvertor phoneNumberDtoConvertor) {
        this.cityDtoConvertor = cityDtoConvertor;
        this.phoneNumberDtoConvertor = phoneNumberDtoConvertor;
    }

    public Patient convert(PatientDto from) {

        Patient patient = new Patient();
        patient.setId(from.getId());
        patient.setPatientNumber(from.getPatientNumber());
        patient.setFirstName(from.getFirstName());
        patient.setLastName(from.getLastName());
        patient.setNationalIdentityNumber(from.getNationalIdentityNumber());
        patient.setSex(from.getSex());
        patient.setMumName(from.getMumName());
        patient.setDadName(from.getDadName());
        patient.setBirthDayOfPatient(from.getBirthDayOfPatient());
        patient.setAge(from.getAge());
        patient.setIsActive(from.getIsActive());
        patient.setCurrentStateOfPatient(from.getCurrentStateOfPatient());
        patient.setPlaceOfBirth(cityDtoConvertor.convert(from.getPlaceOfBirth()));
        patient.setPhoneNumbers(from
                .getPhoneNumbers()
                .stream()
                .map((p) -> phoneNumberDtoConvertor.convert(p))
                .collect(Collectors.toList()));
        patient.setCreatedDate(from.getCreatedDate());

        if (from.getUpdatedDate() != null) {
            patient.setUpdatedDate(from.getUpdatedDate());
        }

        return patient;
    }

    public PatientDto convert(Patient from) {

        PatientDto patientDto = new PatientDto();
        patientDto.setId(from.getId());
        patientDto.setPatientNumber(from.getPatientNumber());
        patientDto.setFirstName(from.getFirstName());
        patientDto.setLastName(from.getLastName());
        patientDto.setNationalIdentityNumber(from.getNationalIdentityNumber());
        patientDto.setSex(from.getSex());
        patientDto.setMumName(from.getMumName());
        patientDto.setDadName(from.getDadName());
        patientDto.setBirthDayOfPatient(from.getBirthDayOfPatient());
        patientDto.setAge(from.getAge());
        patientDto.setIsActive(from.getIsActive());
        patientDto.setCurrentStateOfPatient(from.getCurrentStateOfPatient());
        patientDto.setPlaceOfBirth(cityDtoConvertor.convert(from.getPlaceOfBirth()));
        patientDto.setPhoneNumbers(from
                .getPhoneNumbers()
                .stream()
                .map((p) -> phoneNumberDtoConvertor.convert(p))
                .collect(Collectors.toList()));
        patientDto.setCreatedDate(from.getCreatedDate());

        if (from.getUpdatedDate() != null) {
            patientDto.setUpdatedDate(from.getUpdatedDate());
        }

        return patientDto;
    }
}
