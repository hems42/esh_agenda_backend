package peker.software.esh_agenda_backend.bussiness;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.core.utils.Messages;
import peker.software.esh_agenda_backend.dataAccess.CityDao;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dtoConvertor.CityDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreateCityRequest;
import peker.software.esh_agenda_backend.entities.Patient;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.exception.AlreadyExistCityException;
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
        return noneMatchCity(cityRequest.getCityName()) == true ?
                convertor.convert(cityDao
                        .save(new City(0, cityRequest.getCityName()))) :
                new CityDto();
    }

    public CityDto getCityById(Integer id) {
        return convertor.convert(findCityById(id));
    }

    public List<CityDto> getAllCitiesByPatient(Patient patient) {
        return null;
    }

    public List<CityDto> getAllCities() {
        return cityDao.findAll().stream().map((c) -> convertor.convert(c)).collect(Collectors.toList());
    }

    public City findCityById(Integer id) {
        return cityDao.findById(id).orElseThrow(() -> new NotFoundCityException(Messages.MSG_NOT_FOUND_CITY));
    }

    private Boolean noneMatchCity(String cityName) {

        if (cityDao.existsCityByCityName(cityName)) {
            throw new AlreadyExistCityException(Messages.MSG_ALL_READY_EXIST_CITY + " " + cityName);
        } else {
            return true;
        }
    }

}
