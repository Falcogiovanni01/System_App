package com.example.app_ldap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Configuration
public class OAuth2ClientConfig {

    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
    private String clientSecret;

    @Value("${keycloak.auth-uri}")
    private String authUri;

    @Value("${keycloak.token-uri}")
    private String tokenUri;

    @Value("${keycloak.user-info-uri}")
    private String userInfoUri;

    @Value("${keycloak.jwk-set-uri}")
    private String jwkSetUri;



  @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration registration = ClientRegistration.withRegistrationId("keycloak")
                .clientId(clientId)
                .clientSecret(clientSecret)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email", "roles")
                
               
                // Browser -> HTTPS Localhost (tramite Nginx-User)
                .authorizationUri(authUri)
                
                // Backend -> HTTP Interno Docker (tramite porta 8080 diretta)
                .tokenUri(tokenUri)
                .userInfoUri(userInfoUri)
                .jwkSetUri(jwkSetUri)
                // -----------------------------
                
                .userNameAttributeName("preferred_username")
                .clientName("Keycloak")
                .build();

        return new InMemoryClientRegistrationRepository(registration);
    }
}
