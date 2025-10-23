package com.example.HealthClientServer.manager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

public class TokenManager {

    @Value("app")
    private String clientRegistrationName;

    @Value("advicegenerator")
    private String clientId;

    private final OAuth2AuthorizedClientManager authorizedClientManager;

    public TokenManager(OAuth2AuthorizedClientManager authorizedClientManager) {
        this.authorizedClientManager = authorizedClientManager;
    }

    public String getAccessToken(){
        OAuth2AuthorizeRequest auth2AuthorizeRequest =
                OAuth2AuthorizeRequest.withClientRegistrationId(clientRegistrationName)
                        .principal(clientId)
                        .build();

        OAuth2AuthorizedClient authorizedClient =
                this.authorizedClientManager.authorize(auth2AuthorizeRequest);

        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();

        return accessToken.getTokenValue();
    }

}
