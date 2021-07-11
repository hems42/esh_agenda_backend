package peker.software.esh_agenda_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import peker.software.esh_agenda_backend.entities.utils.CurrentStateOfPatient;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private String id;

    private String patientNumber;

    private String firstName;

    private String lastName;

    private String nationalIdentityNumber;

    private String sex;

    private String mumName;

    private String dadName;

    private LocalDate birthDayOfPatient;

    private int age;

    private String placeOfBirth;

    private Boolean isActive = true;

    private CurrentStateOfPatient currentStateOfPatient;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
