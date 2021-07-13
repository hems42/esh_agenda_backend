package peker.software.esh_agenda_backend.dtoConvertor;

import org.springframework.stereotype.Component;
import peker.software.esh_agenda_backend.entities.utils.City;

@Component
public class CityDtoConvertor {

    public City convert(peker.software.esh_agenda_backend.dto.CityDto from) {
        return new City(
                from.getId(),
                from.getCityName()
        );
    }

    public peker.software.esh_agenda_backend.dto.CityDto convert(City from) {
        return new peker.software.esh_agenda_backend.dto.CityDto(
                from.getId(),
                from.getCityName()
        );
    }
}
