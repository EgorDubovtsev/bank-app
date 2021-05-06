package bank.system.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Random;

@Configuration
@EnableAspectJAutoProxy
public class MainConfiguration {
    @Bean
    public Random random(){
        return new Random();
    }
}
