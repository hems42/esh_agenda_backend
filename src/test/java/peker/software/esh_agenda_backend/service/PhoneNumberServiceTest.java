package peker.software.esh_agenda_backend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peker.software.esh_agenda_backend.repository.PhoneNumberDao;
import peker.software.esh_agenda_backend.dtoConvertor.PhoneNumberDtoConvertor;

import static org.mockito.Mockito.mock;

class PhoneNumberServiceTest {

    private PhoneNumberDao phoneNumberDao;
    private PhoneNumberDtoConvertor phoneNumberDtoConvertor;
    private PhoneNumberService phoneNumberService;

    @BeforeEach
    void setUp() {

        phoneNumberDao = mock(PhoneNumberDao.class);
        phoneNumberDtoConvertor = mock(PhoneNumberDtoConvertor.class);
        phoneNumberService = new PhoneNumberService(phoneNumberDao, phoneNumberDtoConvertor);
    }

    @Test
    void testCreatePhoneNumber_when_NotAlreadyExistNumber_itShouldReturn_phoneNumberDto() {
    }

    @Test
    void testCreatePhoneNumber_when_AlreadyExistNumber_itShouldThrow_AlreadyExistPhoneNumberException() {
    }

    @Test
    void getPhoneNumberById() {
    }

    @Test
    void getAllPhoneNumbersByPatient() {
    }
}