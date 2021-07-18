package peker.software.esh_agenda_backend.entities;


import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.entities.utils.CurrentStateOfPatient;
import peker.software.esh_agenda_backend.entities.utils.PhoneNumber;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Patients",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "PatientNumber", name = "UK_PATIENT_NUMBER"
                ),
                @UniqueConstraint(columnNames = "NationalIdentityNumber", name = "UK_NATIONAL_IDENTITY_NUMBER")

        }
)
public class Patient implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PatientId")
    private UUID id;

    @Column(name = "PatientNumber", nullable = false, length = 40)
    private String patientNumber;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(name = "NationalIdentityNumber", length = 20, nullable = false)
    private String nationalIdentityNumber;

    @Column(nullable = false)
    private String sex;

    @Column(length = 50, nullable = false)
    private String mumName;

    @Column(length = 50, nullable = false)
    private String dadName;

    @Column(nullable = false)
    private LocalDate birthDayOfPatient;

    @Column(length = 3)
    private int age;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private City placeOfBirth;

    @OneToMany(mappedBy ="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<PhoneNumber> phoneNumbers;

    private Boolean isActive = true;

    @Column(nullable = false)
    private CurrentStateOfPatient currentStateOfPatient = CurrentStateOfPatient.ACTIVE;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate", insertable = false)
    private LocalDateTime updatedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Patient patient = (Patient) o;

        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return 1748842812;
    }
}
