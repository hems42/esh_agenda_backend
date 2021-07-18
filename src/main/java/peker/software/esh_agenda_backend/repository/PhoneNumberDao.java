package peker.software.esh_agenda_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peker.software.esh_agenda_backend.domain.Patient;
import peker.software.esh_agenda_backend.domain.utils.PhoneNumber;

import java.util.List;

public interface PhoneNumberDao extends JpaRepository<PhoneNumber, Integer> {


    List<PhoneNumber> findAllByPatient(Patient patient);

    Boolean existsPhoneNumberByPhoneNumber(String phoneNumber);

    Boolean existsPhoneNumberByPatient(Patient patient);

}
