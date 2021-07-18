package peker.software.esh_agenda_backend.service;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.core.utils.Messages;
import peker.software.esh_agenda_backend.repository.PhoneNumberDao;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.dtoConvertor.PhoneNumberDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePhoneNumberRequest;
import peker.software.esh_agenda_backend.domain.Patient;
import peker.software.esh_agenda_backend.domain.utils.PhoneNumber;
import peker.software.esh_agenda_backend.exception.AlreadyExistPhoneNumberException;
import peker.software.esh_agenda_backend.exception.NotFoundPhoneNumberException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    private final PhoneNumberDao phoneNumberDao;
    private final PhoneNumberDtoConvertor phoneNumberDtoConvertor;

    public PhoneNumberService(PhoneNumberDao phoneNumberDao,
                              PhoneNumberDtoConvertor phoneNumberDtoConvertor) {
        this.phoneNumberDao = phoneNumberDao;
        this.phoneNumberDtoConvertor = phoneNumberDtoConvertor;
    }

    public PhoneNumberDto createPhoneNumber(Patient patient,
                                            CreatePhoneNumberRequest phoneNumberRequest) {
        return noneMatchPhoneNumber(
                phoneNumberRequest.getPhoneNumber()) == true ?
                phoneNumberDtoConvertor
                        .convert(phoneNumberDao
                                .save(new PhoneNumber(
                                        0,
                                        phoneNumberRequest.getPhoneNumber(),
                                        phoneNumberRequest.getNumberDescription(),
                                        patient
                                ))) : new PhoneNumberDto();
    }


    public PhoneNumberDto getPhoneNumberById(Integer id) {
        return phoneNumberDtoConvertor.convert(findPhoneNumberById(id));
    }

    public List<PhoneNumberDto> getAllPhoneNumbersByPatient(Patient patient) {
        return phoneNumberDao
                .findAllByPatient(patient)
                .stream().map((p) -> phoneNumberDtoConvertor.convert(p))
                .collect(Collectors.toList());
    }

    private PhoneNumber findPhoneNumberById(Integer id) {
        return phoneNumberDao.findById(id)
                .orElseThrow(() -> new NotFoundPhoneNumberException(
                        Messages.MSG_NOT_FOUND_PHONE_NUMBER));
    }

    private Boolean noneMatchPhoneNumber(String phoneNumber) {

        if (phoneNumberDao.existsPhoneNumberByPhoneNumber(phoneNumber)) {
            throw new AlreadyExistPhoneNumberException(Messages.MSG_ALL_READY_PHONE_NUMBER + " " + phoneNumber);
        } else {
            return true;
        }

    }
}
