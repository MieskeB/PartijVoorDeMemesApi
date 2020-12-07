package nl.partijvoordememes.api.controller;

import nl.partijvoordememes.api.controller.dto.ContactDto;
import nl.partijvoordememes.api.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/contact")
public class ContactController {

    @Autowired
    private MailSenderService mailSenderService;

    @PostMapping("/")
    public ResponseEntity sendContact(@RequestBody ContactDto contactDto) {
        String text = contactDto.getMessage();
        text += "\n\nThis message is sent by " + contactDto.getName();
        text += "\n\nThis is an automatically generated message";
        this.mailSenderService.sendEmail(contactDto.getEmail(), "contact@partijvoordememes.nl", contactDto.getSubject(), text);
        return ResponseEntity.noContent().build();
    }
}
