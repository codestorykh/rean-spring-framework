package com.rean.repository;

import com.rean.model.OAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OAuthClientDetailsRepository extends JpaRepository<OAuthClientDetails, String> {

    Optional<OAuthClientDetails> findAllByClientId(String clientId);

    OAuthClientDetails findByClientId(String clientId);

}
