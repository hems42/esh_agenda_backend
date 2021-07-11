package peker.software.esh_agenda_backend.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SocialSecurities",
        uniqueConstraints = {
                @UniqueConstraint(name = "SocialSecurity",columnNames = "UK_SOCIAL_SECURITY")
        }
)
public class SocialSecurity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SocialSecurityId")
    private String id;

    @Column(name="SocialSecurity",nullable = false)
    private String socialSecurity;
}
