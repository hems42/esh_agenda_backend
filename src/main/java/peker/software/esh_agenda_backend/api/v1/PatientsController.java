package peker.software.esh_agenda_backend.api.v1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peker.software.esh_agenda_backend.bussiness.PatientService;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePatientRequest;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/patients")
public class PatientsController {

    private final PatientService patientService;

    public PatientsController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/createPatient")
    public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody CreatePatientRequest patientRequest) {
        return ResponseEntity.ok(patientService.createPatient(patientRequest));
    }

}
