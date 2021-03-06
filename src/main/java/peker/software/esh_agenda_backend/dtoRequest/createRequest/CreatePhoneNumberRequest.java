package peker.software.esh_agenda_backend.dtoRequest.createRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePhoneNumberRequest {
    private String phoneNumber;

    private String numberDescription;
}
