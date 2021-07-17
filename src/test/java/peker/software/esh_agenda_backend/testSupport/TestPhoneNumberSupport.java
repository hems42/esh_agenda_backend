package peker.software.esh_agenda_backend.testSupport;

import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.entities.utils.CurrentStateOfPatient;
import peker.software.esh_agenda_backend.entities.utils.PhoneNumber;

import java.time.LocalDate;
import java.util.Arrays;

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
