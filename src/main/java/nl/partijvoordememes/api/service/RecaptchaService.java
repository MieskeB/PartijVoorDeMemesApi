package nl.partijvoordememes.api.service;

import nl.partijvoordememes.api.config.RecaptchaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecaptchaService {

    @Autowired
    private RecaptchaConfig recaptchaConfig;


}
