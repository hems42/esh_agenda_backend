package peker.software.esh_agenda_backend.bussiness;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import peker.software.esh_agenda_backend.dataAccess.PatientDao;
import peker.software.esh_agenda_backend.dtoConvertor.PatientDtoConvertor;

import static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.*;

class PatientServiceTest {

    private PatientService patientService;
    private PatientDao patientDao;
    private PatientDtoConvertor patientDtoConvertor;

    @BeforeEach
    void setUp() {
        patientDao=mock(PatientDao.class);
    }


    public void testCreatePatient_itShouldReturn_PatientDto()
    {

    }
}