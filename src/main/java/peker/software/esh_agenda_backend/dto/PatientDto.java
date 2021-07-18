package peker.software.esh_agenda_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import peker.software.esh_agenda_backend.domain.utils.CurrentStateOfPatient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private UUID id;

    private String patientNumber;

    private String firstName;

    private String lastName;

    private String nationalIdentityNumber;

    private String sex;

    private String mumName;

    private String dadName;

    private LocalDate birthDayOfPatient;

    private int age;

    private CityDto placeOfBirth;

    private List<PhoneNumberDto> phoneNumbers;

    private Boolean isActive = true;

    private CurrentStateOfPatient currentStateOfPatient;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
