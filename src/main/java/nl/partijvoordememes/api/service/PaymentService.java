package nl.partijvoordememes.api.service;

import be.woutschoovaerts.mollie.Client;
import be.woutschoovaerts.mollie.ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Client client;

    public PaymentService() {
        String mollieApiKey = System.getProperty("MOLLIEAPIKEY", "");
        client = new ClientBuilder()
                .withApiKey(mollieApiKey)
                .build();

        boolean dev = Boolean.parseBoolean(System.getProperty("DEVELOPMENT", "false"));
        if (dev) {
            client.enableTestMode();
        } else {
            client.disableTestMode();
        }
    }

    public String createPayment() {
        client.getEndpoint();
        return "";
    }

    public boolean confirmPayment() {
        return false;
    }
}
