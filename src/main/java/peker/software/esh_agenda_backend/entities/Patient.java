package peker.software.esh_agenda_backend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patients",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "PatientNumber", name = "UK_PATIENT_NUMBER"),
                @UniqueConstraint(columnNames = "NationalIdentityNumber", name = "UK_NATIONAL_IDENTITY_NUMBER")
                            }
)
public class Patient {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PatientId")
    private String  id;

    @Column(name = "PatientNumber", nullable = false, length = 40)
    private String patientNumber;

    @Column(length = 50,nullable = false)
    private String firstName;

    @Column(length = 50,nullable = false)
    private String lastName;

    @Column(name="NationalIdentityNumber",length=20,nullable = false)
    private String nationalIdentityNumber;

    @Column(nullable = false)
    private String sex;

    @Column(length = 50,nullable = false)
    private String mumName;

    @Column(length = 50,nullable = false)
    private String dadName;

    @Column(nullable = false)
    private LocalDate birthDayOfPatient;

    @Column(length = 40)
    private int age;












    @Column(name = "CreatedDate",updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate",insertable = false)
    private LocalDateTime updatedDate;
}
