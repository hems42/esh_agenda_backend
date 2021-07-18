package peker.software.esh_agenda_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peker.software.esh_agenda_backend.domain.Patient;

import java.util.UUID;

public interface PatientDao extends JpaRepository<Patient, UUID> {

    Boolean existsPatientByNationalIdentityNumber(String nationalIdentityNumber);

}
