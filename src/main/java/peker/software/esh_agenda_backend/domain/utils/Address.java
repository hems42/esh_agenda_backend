package peker.software.esh_agenda_backend.domain.utils;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Addresses"
      /*  uniqueConstraints = {
                @UniqueConstraint(name = "UK_CITY_NAME",columnNames = "CityName")
        }*/
)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressId")
    private Integer id;


}
