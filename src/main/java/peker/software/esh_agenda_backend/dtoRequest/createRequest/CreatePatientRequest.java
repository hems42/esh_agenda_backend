package peker.software.esh_agenda_backend.dtoRequest.createRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.entities.utils.CurrentStateOfPatient;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientRequest {

    private String firstName;

    private String lastName;

    private String nationalIdentityNumber;

    private String sex;

    private String mumName;

    private String dadName;

    private LocalDate birthDayOfPatient;

    private int age;

    private City placeOfBirth;


    public static Patient convert(CreatePatientRequest from) {

        Patient patient = new Patient(
                null,
                from.getFirstName().substring(0,2)
                        +from.getLastName().substring(0,2)
                        +"-"
                        +LocalDate.now(),
                from.getFirstName(),
                from.getLastName(),
                from.getNationalIdentityNumber(),
                from.getSex(),
                from.getMumName(),
                from.getDadName(),
                from.getBirthDayOfPatient(),
                from.getAge(),
                from.getPlaceOfBirth(),
                true,
                CurrentStateOfPatient.ACTIVE,
                null,
                null
        );
        return patient;
    }
}
