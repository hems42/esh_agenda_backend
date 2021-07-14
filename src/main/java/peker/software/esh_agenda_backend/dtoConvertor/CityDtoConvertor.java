package peker.software.esh_agenda_backend.dtoConvertor;

import org.springframework.stereotype.Component;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.entities.utils.City;

@Component
public class CityDtoConvertor {

    public City convert(CityDto from) {
        return new City(
                from.getId(),
                from.getCityName()
        );
    }

    public CityDto convert(City from) {
        return new CityDto(
                from.getId(),
                from.getCityName()
        );
    }
}
