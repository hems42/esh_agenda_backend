package peker.software.esh_agenda_backend.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.PhoneNumber;

import java.util.List;
import java.util.Optional;

public interface PhoneNumberDao extends JpaRepository<PhoneNumber, Integer> {


    List<PhoneNumber> findAllByPatient(Patient patient);

    Boolean existsPhoneNumberByPhoneNumber(String phoneNumber);
}
