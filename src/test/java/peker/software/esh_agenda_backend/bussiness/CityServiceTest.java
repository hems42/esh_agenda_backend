package peker.software.esh_agenda_backend.bussiness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peker.software.esh_agenda_backend.dataAccess.CityDao;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dtoConvertor.CityDtoConvertor;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreateCityRequest;
import peker.software.esh_agenda_backend.entities.utils.City;
import peker.software.esh_agenda_backend.exception.AlreadyExistCityException;
import peker.software.esh_agenda_backend.testSupport.TestCitySupport;

import java.util.Optional;

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
    }

    @Test
    void testGetCityById_whenNotExistCity_itShouldThrow_NotFoundCityException() {
    }


    @Test
    void testGetAllCities_whenExistCityOrCities_itShouldReturn_ListOfCityDto() {
    }

    @Test
    void testGetAllCities_whenNotExistCity_itShouldThrow_NotFoundCityException() {
    }

    @Test
    void testFindCityById_whenExistCity_itShouldReturn_City() {

    }

    @Test
    void testFindCityById_whenNotExistCity_itShouldThrow_NotFoundCityException() {

    }


    //UPDATE

    @Test
    void updateCityById() {

    }


    //DELETE

    @Test
    void deleteAllCities() {

    }

    @Test
    void deleteCityById() {

    }


}