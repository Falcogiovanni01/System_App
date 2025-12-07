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

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration keycloakRegistration = ClientRegistration
                .withRegistrationId("keycloak")
                .clientId(clientId)
                .clientSecret(clientSecret)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email", "roles")
                .authorizationUri("http://localhost/realms/mensa/protocol/openid-connect/auth")
                .tokenUri("http://keycloak:8080/realms/mensa/protocol/openid-connect/token")
                .userInfoUri("http://keycloak:8080/realms/mensa/protocol/openid-connect/userinfo")
                .jwkSetUri("http://keycloak:8080/realms/mensa/protocol/openid-connect/certs")
                .userNameAttributeName("preferred_username")
                .clientName("Keycloak")
                .build();

        return new InMemoryClientRegistrationRepository(keycloakRegistration);
    }
}