package peker.software.esh_agenda_backend.bussiness;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.core.utils.Messages;
import peker.software.esh_agenda_backend.dataAccess.PatientDao;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.dtoConvertor.PatientDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePatientRequest;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePhoneNumberRequest;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.exception.AlreadyExistUserException;
import peker.software.esh_agenda_backend.exception.NotFoundUserException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientDao patientDao;
    private final PatientDtoConvertor patientDtoConvertor;
    private final CityService cityService;
    private final PhoneNumberService phoneNumberService;


    public PatientService(
            PatientDao patientDao,
            PatientDtoConvertor patientDtoConvertor,
            CityService cityService,
            PhoneNumberService phoneNumberService) {
        this.patientDao = patientDao;
        this.patientDtoConvertor = patientDtoConvertor;
        this.cityService = cityService;
        this.phoneNumberService = phoneNumberService;
    }

    public PatientDto createPatient(CreatePatientRequest patientRequest) {

        City city = cityService.findCityById(patientRequest.getPlaceOfBirthId());

        Patient patient = CreatePatientRequest.convert(patientRequest);

        patient.setCreatedDate(LocalDateTime.now());

        patient.setPlaceOfBirth(city);

        return noneMatchPatient(patientRequest
                .getNationalIdentityNumber()) == true
                ? patientDtoConvertor
                .convert(patientDao.save(patient))
                : new PatientDto();
    }

    public List<PhoneNumberDto> addPhoneNumbersByPatientId(UUID patientId,
                                                           List<CreatePhoneNumberRequest> phoneNumberRequests) {

        Patient patient = findPatientById(patientId);

        return phoneNumberRequests
                .stream()
                .map((p) -> phoneNumberService
                        .createPhoneNumber(patient, p))
                .collect(Collectors.toList());
    }

    public Patient findPatientById(UUID patientId) {
        return patientDao.findById(patientId).orElseThrow(() -> new NotFoundUserException(Messages.MSG_NOT_FOUND_PATIENT));
    }

    public Boolean noneMatchPatient(String nationalIdentityNumber) {

        if (patientDao.existsPatientByNationalIdentityNumber(nationalIdentityNumber)) {
            throw new AlreadyExistUserException(Messages.MSG_ALL_READY_PATIENT + " Tc No: " + nationalIdentityNumber);
        } else {
            return true;
        }
    }
}
