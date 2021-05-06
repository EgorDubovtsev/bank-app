package bank.starter.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditConfiguration {
    @Bean
    public CreditSystemListener creditSystemListener(){
        return new CreditSystemListener();
    }
}
