package peker.software.esh_agenda_backend.api.v1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peker.software.esh_agenda_backend.bussiness.PatientService;
import peker.software.esh_agenda_backend.dto.PatientDto;
import peker.software.esh_agenda_backend.dto.PhoneNumberDto;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePatientRequest;
import peker.software.esh_agenda_backend.dtoRequest.createRequest.CreatePhoneNumberRequest;
import peker.software.esh_agenda_backend.entities.utils.PhoneNumber;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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

    @PutMapping("/addPhoneNumbersToPatient")
    public ResponseEntity<List<PhoneNumberDto>> addPhoneNumberByPatientId(
            @Valid @RequestParam UUID patientId,
            @RequestBody List<CreatePhoneNumberRequest> phoneNumberRequestes) {
        return ResponseEntity.ok(patientService.
                addPhoneNumbersByPatientId(patientId,
                        phoneNumberRequestes));
    }

    @GetMapping("/getAllPhoneNumbersByPatientId")
    public ResponseEntity<List<PhoneNumberDto>> getAllPhoneNumberByPatientId(@Valid @RequestParam UUID patientId) {
        return ResponseEntity.ok(patientService.getPhoneNumberByPatientIdAndPhoneNumberId(patientId));
    }

}
