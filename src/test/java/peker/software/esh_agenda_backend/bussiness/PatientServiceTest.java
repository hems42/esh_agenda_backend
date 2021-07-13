package peker.software.esh_agenda_backend.bussiness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peker.software.esh_agenda_backend.dataAccess.PatientDao;
import peker.software.esh_agenda_backend.dtoConvertor.PatientDtoConvertor;

import static org.mockito.Mockito.*;

class PatientServiceTest {

    private PatientService patientService;
    private PatientDao patientDao;
    private PatientDtoConvertor patientDtoConvertor;
    private CityService cityService;

    @BeforeEach
    void setUp() {
        patientDao = mock(PatientDao.class);
        patientDtoConvertor = mock(PatientDtoConvertor.class);
        cityService = mock(CityService.class);
        patientService = new PatientService(patientDao, patientDtoConvertor, cityService);
    }


    @Test
    public void testCreatePatient_itShouldReturn_PatientDto() {


    }
}