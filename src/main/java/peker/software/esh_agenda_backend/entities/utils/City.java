package peker.software.esh_agenda_backend.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cities",
        uniqueConstraints = {
                              @UniqueConstraint(name = "UK_CITY_NAME",columnNames = "CityName")
        }
)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CityId")
    private String id;

    @Column(name="CityName",nullable = false)
    private String cityName;
}
