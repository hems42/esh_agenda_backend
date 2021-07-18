package peker.software.esh_agenda_backend.dtoRequest.updateRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePatientRequest {

    private String firstName;

    private String lastName;

    private String nationalIdentityNumber;

    private String sex;

    private String mumName;

    private String dadName;

    private LocalDate birthDayOfPatient;

    private int age;

    private Integer placeOfBirthId;
}
