package peker.software.esh_agenda_backend.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.entities.utils.CurrentStateOfPatient;
import peker.software.esh_agenda_backend.entities.utils.PhoneNumber;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientDtoConvertorTest {

    private PatientDtoConvertor patientDtoConvertor;
    private CityDtoConvertor cityDtoConvertor;
    private PhoneNumberDtoConvertor phoneNumberDtoConvertor;


    @BeforeEach
    void setUp() {
        cityDtoConvertor = mock(CityDtoConvertor.class);
        patientDtoConvertor = mock(PatientDtoConvertor.class);
        phoneNumberDtoConvertor = mock(PhoneNumberDtoConvertor.class);
        patientDtoConvertor = new PatientDtoConvertor(cityDtoConvertor, phoneNumberDtoConvertor);
    }

    @Test
    void testConvert_itShouldReturn_PatientDto() {

        City city = new City(0, "CITY");

        CityDto cityDto = new CityDto(0, "CITY");

        PhoneNumber phoneNumber = new PhoneNumber(
                0,
                "phoneNumber",
                "phoneNumberDescription",
                null);

        PhoneNumberDto phoneNumberDto = new PhoneNumberDto(
                0,
                "phoneNumber",
                "phoneNumberDescription");

        Patient patient = new Patient(
                null,
                "patientNumber",
                "name",
                "surname",
                "nationalIdentityNumber",
                "sex",
                "mumName",
                "dadName",
                LocalDate.of(1980, 10, 10),
                12,
                city,
                Arrays.asList(phoneNumber),
                true,
                CurrentStateOfPatient.ACTIVE,
                null,
                null
        );

        PatientDto patientDto = new PatientDto(
                null,
                "patientNumber",
                "name",
                "surname",
                "nationalIdentityNumber",
                "sex",
                "mumName",
                "dadName",
                LocalDate.of(1980, 10, 10),
                12,
                cityDto,
                Arrays.asList(phoneNumberDto),
                true,
                CurrentStateOfPatient.ACTIVE,
                null,
                null
        );


        when(cityDtoConvertor.convert(city)).thenReturn(cityDto);
        when(phoneNumberDtoConvertor.convert(phoneNumber)).thenReturn(phoneNumberDto);

        PatientDto patientDtoResult = patientDtoConvertor.convert(patient);


        assertEquals(patientDtoResult, patientDto);

    }

    @Test
    void testConvert_itShouldReturn_Patient() {
        City city = new City(0, "CITY");

        CityDto cityDto = new CityDto(0, "CITY");

        PhoneNumber phoneNumber = new PhoneNumber(
                0,
                "phoneNumber",
                "phoneNumberDescription",
                null);

        PhoneNumberDto phoneNumberDto = new PhoneNumberDto(
                0,
                "phoneNumber",
                "phoneNumberDescription");

        Patient patient = new Patient(
                null,
                "patientNumber",
                "name",
                "surname",
                "nationalIdentityNumber",
                "sex",
                "mumName",
                "dadName",
                LocalDate.of(1980, 10, 10),
                12,
                city,
                Arrays.asList(phoneNumber),
                true,
                CurrentStateOfPatient.ACTIVE,
                null,
                null
        );

        PatientDto patientDto = new PatientDto(
                null,
                "patientNumber",
                "name",
                "surname",
                "nationalIdentityNumber",
                "sex",
                "mumName",
                "dadName",
                LocalDate.of(1980, 10, 10),
                12,
                cityDto,
                Arrays.asList(phoneNumberDto),
                true,
                CurrentStateOfPatient.ACTIVE,
                null,
                null
        );


        when(cityDtoConvertor.convert(cityDto)).thenReturn(city);
        when(phoneNumberDtoConvertor.convert(phoneNumberDto)).thenReturn(phoneNumber);

        Patient patientResult = patientDtoConvertor.convert(patientDto);


        assertEquals(patientResult, patient);

    }
}