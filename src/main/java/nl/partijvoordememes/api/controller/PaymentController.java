package nl.partijvoordememes.api.controller;

import nl.partijvoordememes.api.controller.dto.CreatePaymentDto;
import nl.partijvoordememes.api.model.Member;
import nl.partijvoordememes.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController("/payment")
public class PaymentController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/")
    public ResponseEntity createPayment(@RequestBody CreatePaymentDto createPaymentDto) {
        this.validateFields(createPaymentDto);

        Member member = new Member();
        member.setId(UUID.randomUUID().toString());
        member.setSalutation(createPaymentDto.getSalutation());
        member.setName(createPaymentDto.getFirstName() + " " + createPaymentDto.getMiddleName() + " " + createPaymentDto.getLastName());
        member.setEmail(createPaymentDto.getEmail());
        member.setEmail(createPaymentDto.getEmail());
        member.setPhoneNumber(createPaymentDto.getPhoneNumber());
        member.setCountry(createPaymentDto.getCountry());
        member.setStreet(createPaymentDto.getStreet());
        member.setHouseNumber(createPaymentDto.getHouseNumber());
        member.setPostalCode(createPaymentDto.getPostalCode());
        member.setResidence(createPaymentDto.getResidence());
        member.setPaymentSuccess(false);

        this.memberRepository.save(member);

        // TODO return URL from Mollie Payments https://docs.mollie.com/payments/overview

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    private void validateFields(CreatePaymentDto createPaymentDto) throws ResponseStatusException {
        if (!(createPaymentDto.getSalutation().equals("Dhr.") || createPaymentDto.getSalutation().equals("Mevr."))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Salution must either be 'Dhr.' or 'Mevr.'");
        }
        this.testField(createPaymentDto.getFirstName(), "First name");
        this.testField(createPaymentDto.getLastName(), "Last name");
        this.testField(createPaymentDto.getEmail(), "Email");
        this.testField(createPaymentDto.getCountry(), "Country");
        this.testField(createPaymentDto.getPostalCode(), "Postal code");
        this.testField(createPaymentDto.getResidence(), "Residence");
        this.testField(createPaymentDto.getStreet(), "Street");
        this.testField(createPaymentDto.getHouseNumber(), "House number");
        //TODO validate if address match
    }

    private void testField(String value, String fieldName) {
        if (value.trim().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, fieldName + " is not filled in");
        }
    }
}
