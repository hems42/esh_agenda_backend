package peker.software.esh_agenda_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberDto {

    private Integer id;

    private String phoneNumber;

    private String numberDescription;
}
