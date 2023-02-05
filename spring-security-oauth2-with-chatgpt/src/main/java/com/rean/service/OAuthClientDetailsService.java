package com.rean.service;

import com.rean.model.OAuthClientDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import java.util.Collection;

public interface OAuthClientDetailsService{


    OAuthClientDetails addClientDetails(OAuthClientDetails clientDetails);

    OAuthClientDetails updateClientDetails(OAuthClientDetails clientDetails);

    void updateClientSecret(String clientId, String secret);

    void removeClientDetails(String clientId);

    OAuthClientDetails loadClientByClientId(String clientId);

    Collection<OAuthClientDetails> listClientDetails();
}
