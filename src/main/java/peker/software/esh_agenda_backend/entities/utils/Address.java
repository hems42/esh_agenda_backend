package peker.software.esh_agenda_backend.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
