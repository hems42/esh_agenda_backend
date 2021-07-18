package peker.software.esh_agenda_backend.bussiness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peker.software.esh_agenda_backend.dataAccess.CityDao;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dtoConvertor.CityDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreateCityRequest;
import peker.software.esh_agenda_backend.dtoRequest.updateRequest.UpdateCityRequest;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.exception.AlreadyExistCityException;
import peker.software.esh_agenda_backend.exception.NotFoundCityException;
import peker.software.esh_agenda_backend.testSupport.TestCitySupport;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CityServiceTest {

    private CityDao cityDao;
    private CityDtoConvertor cityDtoConvertor;
    private CityService cityService;

    @BeforeEach
    void setUp() {
        cityDao = mock(CityDao.class);
        cityDtoConvertor = mock(CityDtoConvertor.class);
        cityService = new CityService(cityDao, cityDtoConvertor);
    }


    //CREATE

    @Test
    void testCreateCity_whenNotAlreadyExist_itShouldReturn_CityDto() {

        CreateCityRequest cityRequest = TestCitySupport.generateCreateCityRequest();

        City city = TestCitySupport.generateCity();

        CityDto cityDto = TestCitySupport.generateCityDto();

        when(cityDao.save(city)).thenReturn(city);
        when(cityDtoConvertor.convert(city)).thenReturn(cityDto);

        CityDto cityDtoResult = cityService.createCity(cityRequest);

        assertEquals(cityDto, cityDtoResult);
    }

    @Test
    void testCreateCity_whenAlreadyExist_itShouldThrow_AlreadyExistCityException() {

        CreateCityRequest cityRequest = TestCitySupport.generateCreateCityRequest();

        when(cityDao.existsCityByCityName(cityRequest.getCityName())).thenReturn(true);

        verifyNoInteractions(cityDtoConvertor);

        assertThrows(AlreadyExistCityException.class, () -> cityService.createCity(cityRequest));
    }


    //SELECT

    @Test
    void testGetCityById_whenExistCity_itShouldReturn_CityDto() {

        City city = TestCitySupport.generateCity();

        CityDto cityDto = TestCitySupport.generateCityDto();

        when(cityDao.findById(0)).thenReturn(Optional.of(city));

        when(cityDtoConvertor.convert(city)).thenReturn(cityDto);

        CityDto cityDtoResult = cityService.getCityById(0);

        assertEquals(cityDto, cityDtoResult);
    }

    @Test
    void testGetCityById_whenNotExistCity_itShouldThrow_NotFoundCityException() {

        when(cityDao.findById(0)).thenReturn(Optional.empty());

        assertThrows(NotFoundCityException.class, () -> cityService.getCityById(0));
    }


    @Test
    void testGetAllCities_whenExistCityOrCities_itShouldReturn_ListOfCityDto() {

        City city = TestCitySupport.generateCity();

        CityDto cityDto = TestCitySupport.generateCityDto();

        List<City> cities = Arrays.asList(city);

        List<CityDto> citiesDto = Arrays.asList(cityDto);

        when(cityDao.findAll()).thenReturn(cities);

        when(cityDtoConvertor.convert(city)).thenReturn(cityDto);

        List<CityDto> citiesDtoResult = cityService.getAllCities();

        assertArrayEquals(citiesDto.toArray(), citiesDtoResult.toArray());
    }

    @Test
    void testGetAllCities_whenNotExistCity_itShouldThrow_NotFoundCityException() {

        Optional<City> city = Optional.empty();

        when(cityDao.findAll()).thenReturn(city.stream().collect(Collectors.toList()));

        assertThrows(NotFoundCityException.class, () -> cityService.getAllCities());
    }

    @Test
    void testFindCityById_whenExistCity_itShouldReturn_City() {

        City city = TestCitySupport.generateCity();

        when(cityDao.findById(0)).thenReturn(Optional.of(city));

        City cityResult = cityService.findCityById(0);

        assertEquals(city, cityResult);

    }

    @Test
    void testFindCityById_whenNotExistCity_itShouldThrow_NotFoundCityException() {

        when(cityDao.findById(0)).thenReturn(Optional.empty());

        assertThrows(NotFoundCityException.class, () -> cityService.findCityById(0));

    }


    //UPDATE

    @Test
    void updateCityById() {

        City city = TestCitySupport.generateCity();

        City cityUpdated = new City(0, "CITY UPDATED");

        when(cityDao.findById(0)).thenReturn(Optional.of(city));

        cityService.updateCityById(new UpdateCityRequest("CITY UPDATED"), 0);

        City  cityResult = cityDao.getById(0);

        assertEquals(cityUpdated, cityUpdated);


    }


    //DELETE

    @Test
    void deleteAllCities() {

    }

    @Test
    void deleteCityById() {

    }


}