package peker.software.esh_agenda_backend.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.entities.utils.PhoneNumber;
import peker.software.esh_agenda_backend.testSupport.TestPhoneNumberSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PhoneNumberDtoConvertorTest {

    private PhoneNumberDtoConvertor phoneNumberDtoConvertor;

    @BeforeEach
    void setUp() {
        phoneNumberDtoConvertor = new PhoneNumberDtoConvertor();
    }

    @Test
    void testConvertPhoneNumber_itShouldReturn_phoneNumberDto() {

        PhoneNumber phoneNumber = TestPhoneNumberSupport.generatePhoneNumber();

        PhoneNumberDto phoneNumberDto = TestPhoneNumberSupport.generatePhoneNumberDto();

        PhoneNumberDto phoneNumberDtoResult = phoneNumberDtoConvertor.convert(phoneNumber);

        assertEquals(phoneNumberDto, phoneNumberDtoResult);
    }

    @Test
    void testConvertPhoneNumberDto_itShouldReturn_phoneNumber() {

        PhoneNumber phoneNumber = TestPhoneNumberSupport.generatePhoneNumber();

        PhoneNumberDto phoneNumberDto = TestPhoneNumberSupport.generatePhoneNumberDto();

        PhoneNumber phoneNumberResult = phoneNumberDtoConvertor.convert(phoneNumberDto);


        assertEquals(phoneNumber, phoneNumberResult);
    }
}