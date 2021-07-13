package peker.software.esh_agenda_backend.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PhoneNumbers",
          uniqueConstraints = {
                  @UniqueConstraint(name = "UK_PHONE_NUMBER",columnNames = "phoneNumber")
          }
)
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PhoneNumberId")
    private Integer id;

    @Column(length = 15, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String numberDescription;
}
