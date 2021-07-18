package peker.software.esh_agenda_backend.testSupport;

import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreateCityRequest;
import peker.software.esh_agenda_backend.domain.utils.City;

public class TestCitySupport {

    public static CreateCityRequest generateCreateCityRequest()
    {
        return new CreateCityRequest(
                "CITY"
        );
    }

    public static City generateCity() {

        return new City(0, "CITY");
    }

    public static CityDto generateCityDto() {

        return new CityDto(0, "CITY");
    }
}
