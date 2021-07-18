package peker.software.esh_agenda_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peker.software.esh_agenda_backend.domain.utils.City;

public interface CityDao extends JpaRepository<City, Integer> {

    Boolean existsCityByCityName(String cityName);


}
