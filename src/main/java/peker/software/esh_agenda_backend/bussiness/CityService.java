package peker.software.esh_agenda_backend.bussiness;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.core.utils.Messages;
import peker.software.esh_agenda_backend.dataAccess.CityDao;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dtoConvertor.CityDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreateCityRequest;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.exception.AlReadyExistCityException;
import peker.software.esh_agenda_backend.exception.NotFoundCityException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityDao cityDao;
    private final CityDtoConvertor convertor;

    public CityService(CityDao cityDao, CityDtoConvertor convertor) {
        this.cityDao = cityDao;
        this.convertor = convertor;
    }

    public CityDto createCity(CreateCityRequest cityRequest) {
        if (!anyMatchCity(cityRequest.getCityName())) {
            return convertor.convert(cityDao.save(new City(0, cityRequest.getCityName())));
        } else {
            return new CityDto();
        }
    }

    public CityDto getCityById(Integer id) {
        return convertor.convert(findCityById(id));
    }

    public List<CityDto> getAllCities() {
        return cityDao.findAll().stream().map((c) -> convertor.convert(c)).collect(Collectors.toList());
    }

    private City findCityById(Integer id) {
        return cityDao.findById(id).orElseThrow(() -> new NotFoundCityException(Messages.MSG_NOT_FOUND_CITY));
    }

    private Boolean anyMatchCity(String cityName) {
        CityDto cityDto = new CityDto(0, cityName);
        Boolean result = getAllCities().stream().anyMatch(cityDtoFound -> cityDtoFound == cityDto);

        if (result == true) {
            throw new AlReadyExistCityException(Messages.MSG_ALL_READY_EXIST_CITY + " " + cityName);
        } else {
            return false;

        }
    }

}
