package peker.software.esh_agenda_backend.bussiness;

import org.springframework.stereotype.Service;
import peker.software.esh_agenda_backend.dataAccess.PatientDao;

@Service
public class PatientService {

    private final PatientDao patientDao;


    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }


}
