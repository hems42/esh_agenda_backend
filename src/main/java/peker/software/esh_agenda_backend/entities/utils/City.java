package peker.software.esh_agenda_backend.entities.utils;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
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
    private Integer id;

    @Column(name="CityName",nullable = false,length = 100)
    private String cityName;
}
