package peker.software.esh_agenda_backend.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.domain.utils.City;
import peker.software.esh_agenda_backend.testSupport.TestCitySupport;

import static org.junit.jupiter.api.Assertions.*;

class CityDtoConvertorTest {

    private CityDtoConvertor convertor;

    @BeforeEach
    void setUp() {
        convertor = new CityDtoConvertor();
    }

    @Test
    void testConvert_itShouldReturn_CityDto() {

        City city = TestCitySupport.generateCity();

        CityDto cityDto = TestCitySupport.generateCityDto();

        CityDto cityDtoResult = convertor.convert(city);

        assertEquals(cityDto, cityDtoResult);

    }

    @Test
    void testConvert_itShouldReturn_City() {

        City city = TestCitySupport.generateCity();

        CityDto cityDto = TestCitySupport.generateCityDto();

        City cityResult = convertor.convert(cityDto);

        assertEquals(city, cityResult);

    }
}