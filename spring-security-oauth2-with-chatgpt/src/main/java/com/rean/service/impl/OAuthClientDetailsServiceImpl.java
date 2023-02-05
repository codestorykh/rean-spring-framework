package com.rean.service.impl;

import com.rean.model.OAuthClientDetails;
import com.rean.repository.OAuthClientDetailsRepository;
import com.rean.service.OAuthClientDetailsService;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OAuthClientDetailsServiceImpl implements OAuthClientDetailsService {
    
    private final OAuthClientDetailsRepository oAuthClientDetailsRepository;

    public OAuthClientDetailsServiceImpl(OAuthClientDetailsRepository oAuthClientDetailsRepository) {
        this.oAuthClientDetailsRepository = oAuthClientDetailsRepository;
    }

    @Override
    public OAuthClientDetails addClientDetails(OAuthClientDetails clientDetails) {
       return oAuthClientDetailsRepository.save(clientDetails);
    }

    @Override
    public OAuthClientDetails updateClientDetails(OAuthClientDetails clientDetails) {
        return oAuthClientDetailsRepository.save(clientDetails);
    }

    @Override
    public void updateClientSecret(String clientId, String secret) {
        OAuthClientDetails clientDetails = oAuthClientDetailsRepository.findByClientId(clientId);
        clientDetails.setClientSecret(secret);
        oAuthClientDetailsRepository.save(clientDetails);
    }

    @Override
    public void removeClientDetails(String clientId) {
        oAuthClientDetailsRepository.deleteById(clientId);
    }

    @Override
    public OAuthClientDetails loadClientByClientId(String clientId) {
        OAuthClientDetails clientDetails = oAuthClientDetailsRepository.findByClientId(clientId);
        if (clientDetails == null) {
            throw new InvalidClientException("Client not found with id: " + clientId);
        }
        return clientDetails;
    }

    @Override
    public Collection<OAuthClientDetails> listClientDetails() {
        return oAuthClientDetailsRepository.findAll();
    }
}
