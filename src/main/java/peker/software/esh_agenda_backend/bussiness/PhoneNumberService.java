package peker.software.esh_agenda_backend.bussiness;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.core.utils.Messages;
import peker.software.esh_agenda_backend.dataAccess.PhoneNumberDao;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.dtoConvertor.PhoneNumberDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePhoneNumberRequest;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.PhoneNumber;
import peker.software.esh_agenda_backend.exception.AlreadyExistPhoneNumberException;
import peker.software.esh_agenda_backend.exception.NotFoundPhoneNumberException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    private final PhoneNumberDao phoneNumberDao;
    private final PhoneNumberDtoConvertor phoneNumberDtoConvertor;

    public PhoneNumberService(PhoneNumberDao phoneNumberDao, PhoneNumberDtoConvertor phoneNumberDtoConvertor) {
        this.phoneNumberDao = phoneNumberDao;
        this.phoneNumberDtoConvertor = phoneNumberDtoConvertor;
    }

    public PhoneNumberDto createPhoneNumber(Patient patient,CreatePhoneNumberRequest phoneNumberRequest) {
        return anyMatchPhoneNumber(
                phoneNumberRequest.getPhoneNumber()) == false ?
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
        return phoneNumberDtoConvertor.convert(gettPhoneNumberById(id));
    }

    public List<PhoneNumberDto> getAllPhoneNumbersByPatient(Patient patient) {
        return phoneNumberDao
                .findAllByPatient(patient)
                .stream().map((p) -> phoneNumberDtoConvertor.convert(p))
                .collect(Collectors.toList());
    }

    private PhoneNumber gettPhoneNumberById(Integer id) {
        return phoneNumberDao.findById(id).orElseThrow(() -> new NotFoundPhoneNumberException(Messages.MSG_NOT_FOUND_PHONE_NUMBER));
    }

    private Boolean anyMatchPhoneNumber(String phoneNumber) {
        Boolean result = phoneNumberDao.findAll().stream()
                .anyMatch((p) -> p.getPhoneNumber() == phoneNumber ? true : false);
        if (result == false) {
            return false;
        } else {
            throw new AlreadyExistPhoneNumberException(Messages.MSG_ALL_READY_PHONE_NUMBER + " " + phoneNumber);
        }

    }

}
