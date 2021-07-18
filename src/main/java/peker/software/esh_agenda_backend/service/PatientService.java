package peker.software.esh_agenda_backend.service;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.core.utils.Messages;
import peker.software.esh_agenda_backend.repository.PatientDao;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.dtoConvertor.PatientDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePatientRequest;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePhoneNumberRequest;
import peker.software.esh_agenda_backend.dtoRequest.updateRequest.UpdatePatientRequest;
import peker.software.esh_agenda_backend.domain.Patient;
import peker.software.esh_agenda_backend.domain.utils.City;
import peker.software.esh_agenda_backend.domain.utils.CurrentStateOfPatient;
import peker.software.esh_agenda_backend.domain.utils.PhoneNumber;
import peker.software.esh_agenda_backend.exception.AlreadyExistUserException;
import peker.software.esh_agenda_backend.exception.NotFoundUserException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
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

    //PATIENT

    public PatientDto createPatient(CreatePatientRequest patientRequest) {

        Patient patient = new Patient();
        patient.setPatientNumber(patientRequest.getFirstName().substring(0, 2)
                + patientRequest.getLastName().substring(0, 2)
                + "-"
                + LocalDateTime.now());
        patient.setFirstName(patientRequest.getFirstName());
        patient.setLastName(patientRequest.getLastName());
        patient.setNationalIdentityNumber(patientRequest.getNationalIdentityNumber());
        patient.setSex(patientRequest.getSex());
        patient.setMumName(patientRequest.getMumName());
        patient.setDadName(patientRequest.getDadName());
        patient.setBirthDayOfPatient(patientRequest.getBirthDayOfPatient());
        patient.setAge(patientRequest.getAge());
        patient.setIsActive(true);
        patient.setCurrentStateOfPatient(CurrentStateOfPatient.ACTIVE);
        patient.setCreatedDate(LocalDateTime.now());
        patient.setPlaceOfBirth(getCityById(patientRequest.getPlaceOfBirthId()));

        return noneMatchPatient(patientRequest
                .getNationalIdentityNumber()) == true
                ? patientDtoConvertor
                .convert(patientDao.save(patient))
                : new PatientDto();
    }

    public PatientDto getPatientById(UUID patientId) {
        return patientDtoConvertor.convert(findPatientById(patientId));
    }

    public List<PatientDto> getAllPatients() {
        return isThereAnyPatient() == true ?
                patientDao.findAll().stream().map((p) -> patientDtoConvertor.convert(p))
                        .collect(Collectors.toList()) : null;
    }

    public PatientDto updatePatientById(UUID patientId, UpdatePatientRequest patientRequest) {

        Patient patient = findPatientById(patientId);

        patient.setFirstName(patientRequest.getFirstName());
        patient.setLastName(patientRequest.getLastName());
        patient.setNationalIdentityNumber(patientRequest.getNationalIdentityNumber());
        patient.setSex(patientRequest.getSex());
        patient.setMumName(patientRequest.getMumName());
        patient.setDadName(patientRequest.getDadName());
        patient.setBirthDayOfPatient(patientRequest.getBirthDayOfPatient());
        patient.setAge(patientRequest.getAge());
        patient.setPlaceOfBirth(getCityById(patientRequest.getPlaceOfBirthId()));

        return patientDtoConvertor.convert(patientDao.save(patient));
    }

    public PatientDto updatePatientByPatient(Patient patientRequest) {

        Patient patient = findPatientById(patientRequest.getId());

        patient.setFirstName(patientRequest.getFirstName());
        patient.setLastName(patientRequest.getLastName());
        patient.setNationalIdentityNumber(patientRequest.getNationalIdentityNumber());
        patient.setSex(patientRequest.getSex());
        patient.setMumName(patientRequest.getMumName());
        patient.setDadName(patientRequest.getDadName());
        patient.setBirthDayOfPatient(patientRequest.getBirthDayOfPatient());
        patient.setAge(patientRequest.getAge());
        patient.setPlaceOfBirth(patientRequest.getPlaceOfBirth());

        return patientDtoConvertor.convert(patientDao.save(patient));
    }

    public Boolean setActivePatientById(UUID patientId) {

        Patient patient = findPatientById(patientId);

        patient.setIsActive(true);

        return patientDao.save(patient).getIsActive() == true ? true : false;
    }

    public Boolean setDeActivePatientById(UUID patientId) {

        Patient patient = findPatientById(patientId);

        patient.setIsActive(false);

        return patientDao.save(patient).getIsActive() == false ? true : false;
    }

    public Long getCountOfPatient() {
        return patientDao.count();
    }


    //PHONE_NUMBER
    public List<PhoneNumberDto> addPhoneNumbersByPatientId(UUID patientId,
                                                           List<CreatePhoneNumberRequest> phoneNumberRequests) {

        Patient patient = findPatientById(patientId);

        return phoneNumberRequests
                .stream()
                .map((p) -> phoneNumberService
                        .createPhoneNumber(patient, p))
                .collect(Collectors.toList());
    }

    public PhoneNumberDto addPhoneNumberByPatientId(UUID patientId,
                                                    CreatePhoneNumberRequest phoneNumberRequest) {

        Patient patient = findPatientById(patientId);

        return phoneNumberService.createPhoneNumber(patient, phoneNumberRequest);
    }

    public List<PhoneNumberDto> getPhoneNumberByPatientIdAndPhoneNumberId(UUID patientId) {
        Patient patient = findPatientById(patientId);

        return phoneNumberService.getAllPhoneNumbersByPatient(patient);
    }

    public List<PhoneNumber> getPhoneNumberByPatientIdAndPhoneNumberId(UUID patientId, Integer phoneNumberId) {
        Patient patient = findPatientById(patientId);

        Predicate<PhoneNumber> phoneNumberPredicateFilter = p -> p.getId() == phoneNumberId;


        return patient.getPhoneNumbers().stream().filter(phoneNumberPredicateFilter).collect(Collectors.toList());

    }


    //ADDRESS


    //UTIL

    public Patient findPatientById(UUID patientId) {
        return patientDao.findById(patientId).orElseThrow(() -> new NotFoundUserException(Messages.MSG_NOT_FOUND_PATIENT));
    }

    private Boolean noneMatchPatient(String nationalIdentityNumber) {

        if (patientDao.existsPatientByNationalIdentityNumber(nationalIdentityNumber)) {
            throw new AlreadyExistUserException(Messages.MSG_ALL_READY_PATIENT + " Tc No: " + nationalIdentityNumber);
        } else {
            return true;
        }
    }

    private Boolean isThereAnyPatient() {
        if (patientDao.count() > 0) {
            return true;
        } else {
            throw new NotFoundUserException(Messages.MSG_NOT_FOUND_PATIENT);
        }
    }

    private City getCityById(Integer cityId) {
        return cityService.findCityById(cityId);
    }
}
