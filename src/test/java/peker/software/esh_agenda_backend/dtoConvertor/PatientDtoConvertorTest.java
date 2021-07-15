package peker.software.esh_agenda_backend.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.entities.utils.CurrentStateOfPatient;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientDtoConvertorTest {

    private PatientDtoConvertor patientDtoConvertor;
    private CityDtoConvertor cityDtoConvertor;


    @BeforeEach
    void setUp() {
        cityDtoConvertor = mock(CityDtoConvertor.class);
        patientDtoConvertor = new PatientDtoConvertor(cityDtoConvertor);
    }

    @Test
    void testConvert_itShouldReturn_PatientDto() {

        City city = new City(0, "KONYA");

        CityDto cityDto = new CityDto(0, "KONYA");

        Patient patient = new Patient(
                null,
                "00000",
                "ALİ",
                "YILMAZ",
                "00000000000",
                "ERKEK",
                "ALİYE",
                "HASAN",
                LocalDate.of(1980, 10, 10),
                12,
                city,
                null,
                true,
                CurrentStateOfPatient.ACTIVE,
                null,
                null
        );

        PatientDto patientDto = new PatientDto(
                null,
                "00000",
                "ALİ",
                "YILMAZ",
                "00000000000",
                "ERKEK",
                "ALİYE",
                "HASAN",
                LocalDate.of(1980, 10, 10),
                12,
                null,
                true,
                CurrentStateOfPatient.ACTIVE,
                null,
                null
        );


        PatientDto patientDtoResult= patientDtoConvertor.convert(patient);



        assertEquals(patientDto,patientDtoResult);



    }

    @Test
    void testConvert_itShouldReturn_Patient() {
    }
}