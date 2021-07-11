package peker.software.esh_agenda_backend.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import peker.software.esh_agenda_backend.entities.Patient;

public interface PatientDao extends JpaRepository<Patient,String> {
}
