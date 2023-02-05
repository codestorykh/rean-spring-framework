package com.rean.service;

import com.rean.model.OAuthClientDetails;
import com.rean.repository.OAuthClientDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class CustomClientDetailsService implements ClientDetailsService {
    private final OAuthClientDetailsRepository clientDetailsRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Optional<OAuthClientDetails> client = clientDetailsRepository.findAllByClientId(clientId);
        if (client.isEmpty()) {
            throw new ClientRegistrationException("Client not found: " + clientId);
        }
        return new BaseClientDetails(
        );
    }

}
