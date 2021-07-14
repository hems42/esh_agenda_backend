package peker.software.esh_agenda_backend.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.PhoneNumber;

import java.util.List;

public interface PhoneNumberDao extends JpaRepository<PhoneNumber, Integer> {


    List<PhoneNumber> findAllByPatient(Patient patient);

}
