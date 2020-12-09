package nl.partijvoordememes.api.config;

import com.szityu.oss.spring.recaptcha.lib.callbackhandler.InvalidCaptchaCallbackHandler;
import com.szityu.oss.spring.recaptcha.lib.callbackhandler.MissingCaptchaCallbackHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Configuration
public class RecaptchaConfig {
    @Bean
    public InvalidCaptchaCallbackHandler invalidCaptchaCallbackHandler() {
        return new InvalidCaptchaCallbackHandler() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
                System.out.println(request.getHeader("g-recaptcha-response"));
                System.out.println("lolz");
                response.setStatus(418);
                response.getWriter().append("Beep boop beep boop bap");
            }
        };
    }

    @Bean
    public MissingCaptchaCallbackHandler missingCaptchaCallbackHandler () {
        return new MissingCaptchaCallbackHandler() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
                System.out.println(request.getHeader("g-recaptcha-response"));
                System.out.println("a");
                Enumeration<String> things = request.getHeaderNames();
                response.setStatus(418);
                response.getWriter().append("Beep boop beep boop bap");
            }
        };
    }
}
