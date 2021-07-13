package peker.software.esh_agenda_backend.bussiness;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.dataAccess.PatientDao;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.dtoConvertor.PatientDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePatientRequest;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.City;

import java.time.LocalDateTime;

@Service
public class PatientService {

    private final PatientDao patientDao;
    private final PatientDtoConvertor patientDtoConvertor;
    private final CityService cityService;


    public PatientService(PatientDao patientDao, PatientDtoConvertor patientDtoConvertor, CityService cityService) {
        this.patientDao = patientDao;
        this.patientDtoConvertor = patientDtoConvertor;
        this.cityService = cityService;
    }

    public PatientDto createPatient(CreatePatientRequest patientRequest) {

        City city = cityService.findCityById(patientRequest.getPlaceOfBirthId());

        Patient patient = CreatePatientRequest.convert(patientRequest);

        patient.setCreatedDate(LocalDateTime.now());

        patient.setPlaceOfBirth(city);

        return patientDtoConvertor.convert(patientDao.save(patient));
    }

}
