package peker.software.esh_agenda_backend.testSupport;

import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.domain.utils.PhoneNumber;

public class TestPhoneNumberSupport {

    public static PhoneNumber generatePhoneNumber() {
        return new PhoneNumber(
                0,
                "phoneNumber",
                "phoneNumberDescription",
                null);
    }


    public static PhoneNumberDto generatePhoneNumberDto() {

        return new PhoneNumberDto(
                0,
                "phoneNumber",
                "phoneNumberDescription");
    }
}
