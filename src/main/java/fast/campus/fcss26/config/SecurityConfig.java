package fast.campus.fcss26.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration c = CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("Ov23lidcvYBigcTuAk95")
                .clientSecret("ec5739864c71efa8fb08cd88bff9039f2aeb4eae")
                .build();
        return new InMemoryClientRegistrationRepository(c);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.oauth2Login(c -> c.clientRegistrationRepository(clientRegistrationRepository()));
        httpSecurity.authorizeHttpRequests(a -> a.anyRequest().authenticated());
        return httpSecurity.build();
    }
}
