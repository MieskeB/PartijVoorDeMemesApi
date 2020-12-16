package nl.partijvoordememes.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Member {
    @Id
    private String id;
    private String salutation;
    private String name;

    private String email;
    private String phoneNumber;

    private String country;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String residence;

    private boolean paymentSuccess;
}
