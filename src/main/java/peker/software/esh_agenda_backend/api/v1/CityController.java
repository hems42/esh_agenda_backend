package peker.software.esh_agenda_backend.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peker.software.esh_agenda_backend.bussiness.CityService;
import peker.software.esh_agenda_backend.dto.CityDto;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreateCityRequest;
import peker.software.esh_agenda_backend.dtoRequest.updateRequest.UpdateCityRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/createCities")
    public ResponseEntity<List<CityDto>> createCities(@Valid @RequestBody List<CreateCityRequest> cityRequests) {
        return ResponseEntity
                .ok(cityService.createCities(cityRequests));
    }


    @PostMapping("/createCity")
    public ResponseEntity<CityDto> createCity(@Valid @RequestBody CreateCityRequest cityRequest) {
        return ResponseEntity.ok(cityService.createCity(cityRequest));
    }

    @PutMapping("/updateCityById")
    public ResponseEntity<CityDto> updateCityById(@Valid @RequestBody UpdateCityRequest updateCityRequest,
                                                  @RequestParam Integer cityId) {
        return ResponseEntity.ok(cityService.updateCityById(updateCityRequest, cityId));
    }

    @GetMapping("/getAllCities")
    public ResponseEntity<List<CityDto>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/getAllCityById")
    public ResponseEntity<CityDto> getCityById(@Valid @RequestParam Integer cityId) {
        return ResponseEntity.ok(cityService.getCityById(cityId));
    }

    @PatchMapping("/deleteCityById")
    public ResponseEntity deleteCityById(@Valid @RequestParam Integer cityId) {
        cityService.deleteCityById(cityId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/deleteAllCities")
    public ResponseEntity deleteAllCities() {
        cityService.deleteAllCities();
        return ResponseEntity.ok().build();
    }

}
