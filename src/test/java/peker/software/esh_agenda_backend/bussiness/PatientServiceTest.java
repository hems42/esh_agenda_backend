package peker.software.esh_agenda_backend.bussiness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peker.software.esh_agenda_backend.dataAccess.PatientDao;
import peker.software.esh_agenda_backend.dtoConvertor.PatientDtoConvertor;
import peker.software.esh_agenda_backend.dtoConvertor.PhoneNumberDtoConvertor;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.entities.utils.CurrentStateOfPatient;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class PatientServiceTest {

    private PatientService patientService;
    private PatientDao patientDao;
    private PatientDtoConvertor patientDtoConvertor;
    private CityService cityService;
    private PhoneNumberDtoConvertor phoneNumberDtoConvertor;
    private PhoneNumberService phoneNumberService;

    @BeforeEach
    void setUp() {
        patientDao = mock(PatientDao.class);
        patientDtoConvertor = mock(PatientDtoConvertor.class);
        cityService = mock(CityService.class);
         phoneNumberService = mock(PhoneNumberService.class);
        phoneNumberDtoConvertor = mock(PhoneNumberDtoConvertor.class);
        patientService = new PatientService(patientDao,
                patientDtoConvertor,
                cityService,
                phoneNumberService);
    }


    @Test
    public void testCreatePatient_itShouldReturn_PatientDto() {

        City city=cityService.findCityById(1);

        Patient patient= new Patient(
                null,
                "00000",
                "ALİ",
                "YILMAZ",
                "00000000000",
                    "ERKEK",
                "ALİYE",
                "HASAN",
                LocalDate.of(1980,10,10),
                12,
                city,
                null,
                true,
                CurrentStateOfPatient.ACTIVE,
                LocalDateTime.now(),
                null
                 );



    }


    @Test
    public void testAddPhoneNumbersByPatientId_itShouldReturn_PhoneNumberDto()
    {

    }
}