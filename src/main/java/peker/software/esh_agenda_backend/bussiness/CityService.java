package peker.software.esh_agenda_backend.bussiness;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.core.utils.Messages;
import peker.software.esh_agenda_backend.dataAccess.CityDao;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dtoConvertor.CityDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreateCityRequest;
import peker.software.esh_agenda_backend.dtoRequest.updateRequest.UpdateCityRequest;
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

    public List<CityDto> createCities(List<CreateCityRequest> cityRequests) {
        return cityRequests
                .stream().map((c) -> createCity(c)).collect(Collectors.toList());
    }

    public CityDto getCityById(Integer id) {
        return convertor.convert(findCityById(id));
    }

    public CityDto updateCityById(UpdateCityRequest cityRequest, Integer cityId) {

        City city = findCityById(cityId);

        city.setCityName(cityRequest.getCityName());

        return convertor.convert(cityDao.save(city));
    }

    public void deleteCityById(Integer cityId) {
        cityDao.delete(findCityById(cityId));
    }

    public void deleteAllCities() {
        if (isThereAnyCity()) {
            cityDao.deleteAll();
        }
    }

    public List<CityDto> getAllCities() {
        List<CityDto> citiesDto = cityDao.findAll().stream().map((c) -> convertor.convert(c)).collect(Collectors.toList());

        if (citiesDto.isEmpty()) {
            throw new NotFoundCityException(Messages.MSG_NOT_FOUND_CITY);
        } else {
            return citiesDto;
        }

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

    private Boolean isThereAnyCity() {
        if (cityDao.count() > 0) {
            return true;
        } else {
            throw new NotFoundCityException(Messages.MSG_NOT_FOUND_CITY);
        }
    }
}
