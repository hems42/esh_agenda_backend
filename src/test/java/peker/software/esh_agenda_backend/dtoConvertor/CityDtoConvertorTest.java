package peker.software.esh_agenda_backend.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.entities.utils.City;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CityDtoConvertorTest {

    private CityDtoConvertor convertor;

    @BeforeEach
    void setUp() {
        convertor = new CityDtoConvertor();
    }

    @Test
    void testConvert_itShouldReturn_CityDto() {

        City city = new City(0, "City");

        CityDto cityDto = new CityDto(0, "City");

        CityDto cityDtoResult = convertor.convert(city);

        assertEquals(cityDtoResult, cityDto);

    }

    @Test
    void testConvert_itShouldReturn_City() {

        City city = new City(0, "City");

        CityDto cityDto = new CityDto(0, "City");

        City cityResult = convertor.convert(cityDto);

        assertEquals(cityResult, city);

    }
}