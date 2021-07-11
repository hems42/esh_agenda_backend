package peker.software.esh_agenda_backend.bussiness;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.dataAccess.PatientDao;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.dtoConvertor.PatientDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePatientRequest;
import peker.software.esh_agenda_backend.entities.Patient;

import java.time.LocalDateTime;

@Service
public class PatientService {

    private final PatientDao patientDao;
    private final PatientDtoConvertor patientDtoConvertor;


    public PatientService(PatientDao patientDao, PatientDtoConvertor patientDtoConvertor) {
        this.patientDao = patientDao;
        this.patientDtoConvertor = patientDtoConvertor;
    }

    public PatientDto createPatient(CreatePatientRequest patientRequest) {

        Patient patient = CreatePatientRequest.convert(patientRequest);

        patient.setCreatedDate(LocalDateTime.now());

        return patientDtoConvertor.convert(patientDao.save(patient));
    }

}
