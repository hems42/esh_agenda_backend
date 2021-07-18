package peker.software.esh_agenda_backend.dtoConvertor;

import org.springframework.stereotype.Component;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.domain.utils.PhoneNumber;

@Component
public class PhoneNumberDtoConvertor {

    public PhoneNumberDto convert(PhoneNumber from) {
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setId(from.getId());
        phoneNumberDto.setPhoneNumber(from.getPhoneNumber());
        phoneNumberDto.setNumberDescription(from.getNumberDescription());
        return phoneNumberDto;
    }

    public PhoneNumber convert(PhoneNumberDto from) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(from.getId());
        phoneNumber.setPhoneNumber(from.getPhoneNumber());
        phoneNumber.setNumberDescription(from.getNumberDescription());
        return phoneNumber;
    }
}
