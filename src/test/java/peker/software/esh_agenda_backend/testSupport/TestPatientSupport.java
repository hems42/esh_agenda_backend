package peker.software.esh_agenda_backend.testSupport;

import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.CurrentStateOfPatient;

import java.time.LocalDate;
import java.util.Arrays;

public class TestPatientSupport {

    public static Patient generatePatient() {
        return new Patient(
                null,
                "patientNumber",
                "name",
                "surname",
                "nationalIdentityNumber",
                "sex",
                "mumName",
                "dadName",
                LocalDate.of(1980, 10, 10),
                12,
                null,
                null,
                true,
                CurrentStateOfPatient.ACTIVE,
                null,
                null);
    }

    public static PatientDto generatePatientDto() {
        return new PatientDto(
                null,
                "patientNumber",
                "name",
                "surname",
                "nationalIdentityNumber",
                "sex",
                "mumName",
                "dadName",
                LocalDate.of(1980, 10, 10),
                12,
                null,
                null,
                true,
                CurrentStateOfPatient.ACTIVE,
                null,
                null
        );
    }
}
