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
import peker.software.esh_agenda_backend.testSupport.TestCitySupport;
import peker.software.esh_agenda_backend.testSupport.TestPatientSupport;
import peker.software.esh_agenda_backend.testSupport.TestPhoneNumberSupport;

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

        City city = TestCitySupport.generateCity();

        CityDto cityDto = TestCitySupport.generateCityDto();

        PhoneNumber phoneNumber = TestPhoneNumberSupport.generatePhoneNumber();

        PhoneNumberDto phoneNumberDto = TestPhoneNumberSupport.generatePhoneNumberDto();

        Patient patient = TestPatientSupport.generatePatient();
        patient.setPlaceOfBirth(city);
        patient.setPhoneNumbers(Arrays.asList(phoneNumber));


        PatientDto patientDto = TestPatientSupport.generatePatientDto();
        patientDto.setPlaceOfBirth(cityDto);
        patientDto.setPhoneNumbers(Arrays.asList(phoneNumberDto));


        when(cityDtoConvertor.convert(city)).thenReturn(cityDto);
        when(phoneNumberDtoConvertor.convert(phoneNumber)).thenReturn(phoneNumberDto);

        PatientDto patientDtoResult = patientDtoConvertor.convert(patient);


        assertEquals(patientDto.getId(), patientDtoResult.getId());
        assertEquals(patientDto.getPatientNumber(), patientDtoResult.getPatientNumber());
        assertEquals(patientDto.getFirstName(), patientDtoResult.getFirstName());
        assertEquals(patientDto.getLastName(), patientDtoResult.getLastName());
        assertEquals(patientDto.getNationalIdentityNumber(), patientDtoResult.getNationalIdentityNumber());
        assertEquals(patientDto.getSex(), patientDtoResult.getSex());
        assertEquals(patientDto.getMumName(), patientDtoResult.getMumName());
        assertEquals(patientDto.getDadName(), patientDtoResult.getDadName());
        assertEquals(patientDto.getBirthDayOfPatient(), patientDtoResult.getBirthDayOfPatient());
        assertEquals(patientDto.getAge(), patientDtoResult.getAge());
        assertEquals(patientDto.getPlaceOfBirth(), patientDtoResult.getPlaceOfBirth());
        assertArrayEquals(patientDto.getPhoneNumbers().toArray(), patientDtoResult.getPhoneNumbers().toArray());
        assertEquals(patientDto.getIsActive(), patientDtoResult.getIsActive());
        assertEquals(patientDto.getCurrentStateOfPatient(), patientDtoResult.getCurrentStateOfPatient());

    }

    @Test
    void testConvert_itShouldReturn_Patient() {


        City city = TestCitySupport.generateCity();

        CityDto cityDto = TestCitySupport.generateCityDto();

        PhoneNumber phoneNumber = TestPhoneNumberSupport.generatePhoneNumber();

        PhoneNumberDto phoneNumberDto = TestPhoneNumberSupport.generatePhoneNumberDto();

        Patient patient = TestPatientSupport.generatePatient();
        patient.setPlaceOfBirth(city);
        patient.setPhoneNumbers(Arrays.asList(phoneNumber));


        PatientDto patientDto = TestPatientSupport.generatePatientDto();
        patientDto.setPlaceOfBirth(cityDto);
        patientDto.setPhoneNumbers(Arrays.asList(phoneNumberDto));

        when(cityDtoConvertor.convert(cityDto)).thenReturn(city);
        when(phoneNumberDtoConvertor.convert(phoneNumberDto)).thenReturn(phoneNumber);

        Patient patientResult = patientDtoConvertor.convert(patientDto);


        assertEquals(patient.getId(), patientResult.getId());
        assertEquals(patient.getPatientNumber(), patientResult.getPatientNumber());
        assertEquals(patient.getFirstName(), patientResult.getFirstName());
        assertEquals(patient.getLastName(), patientResult.getLastName());
        assertEquals(patient.getNationalIdentityNumber(), patientResult.getNationalIdentityNumber());
        assertEquals(patient.getSex(), patientResult.getSex());
        assertEquals(patient.getMumName(), patientResult.getMumName());
        assertEquals(patient.getDadName(), patientResult.getDadName());
        assertEquals(patient.getBirthDayOfPatient(), patientResult.getBirthDayOfPatient());
        assertEquals(patient.getAge(), patientResult.getAge());
        assertEquals(patient.getPlaceOfBirth(), patientResult.getPlaceOfBirth());
        assertArrayEquals(patient.getPhoneNumbers().toArray(), patientResult.getPhoneNumbers().toArray());
        assertEquals(patient.getIsActive(), patientResult.getIsActive());
        assertEquals(patient.getCurrentStateOfPatient(), patientResult.getCurrentStateOfPatient());


    }
}