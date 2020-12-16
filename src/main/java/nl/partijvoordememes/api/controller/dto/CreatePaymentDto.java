package nl.partijvoordememes.api.controller.dto;

import lombok.Data;

@Data
public class CreatePaymentDto {
    private String country;
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String residence;
    private String phoneNumber;
    private String email;
}
