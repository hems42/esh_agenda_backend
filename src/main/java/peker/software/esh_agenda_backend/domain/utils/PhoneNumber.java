package peker.software.esh_agenda_backend.domain.utils;

import lombok.*;
import org.hibernate.Hibernate;
import peker.software.esh_agenda_backend.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhoneNumbers",
          uniqueConstraints = {
                  @UniqueConstraint(name = "UK_PHONE_NUMBER",columnNames = "phoneNumber")
          }
)
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PhoneNumberId")
    private Integer id;

    @Column(length = 15, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String numberDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PatientId",nullable = false)
    private Patient patient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PhoneNumber that = (PhoneNumber) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 564916499;
    }
}
