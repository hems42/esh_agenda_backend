package peker.software.esh_agenda_backend.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreateCityRequest;
import peker.software.esh_agenda_backend.entities.utils.City;

public interface CityDao extends JpaRepository<City, Integer> {

    Boolean existsCityByCityName(String cityName);


}
