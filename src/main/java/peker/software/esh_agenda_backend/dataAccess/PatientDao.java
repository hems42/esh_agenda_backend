package peker.software.esh_agenda_backend.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import peker.software.esh_agenda_backend.entities.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientDao extends JpaRepository<Patient, UUID> {

    Boolean existsPatientByNationalIdentityNumber(String nationalIdentityNumber);
}
