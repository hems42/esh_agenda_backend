package peker.software.esh_agenda_backend.dtoConvertor;

import org.springframework.stereotype.Component;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.entities.utils.PhoneNumber;

@Component
public class PhoneNumberDtoConvertor {

    private final PatientDtoConvertor patientDtoConvertor;

    public PhoneNumberDtoConvertor(PatientDtoConvertor patientDtoConvertor) {
        this.patientDtoConvertor = patientDtoConvertor;
    }

    public PhoneNumberDto convert(PhoneNumber from) {
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setId(from.getId());
        phoneNumberDto.setPhoneNumber(from.getPhoneNumber());
        phoneNumberDto.setNumberDescription(from.getNumberDescription());
        phoneNumberDto.setPatient(patientDtoConvertor.convert(from.getPatient()));
        return phoneNumberDto;
    }

    public PhoneNumber convert(PhoneNumberDto from) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(from.getId());
        phoneNumber.setPhoneNumber(from.getPhoneNumber());
        phoneNumber.setNumberDescription(from.getNumberDescription());
        phoneNumber.setPatient(patientDtoConvertor.convert(from.getPatient()));
        return phoneNumber;
    }
}
