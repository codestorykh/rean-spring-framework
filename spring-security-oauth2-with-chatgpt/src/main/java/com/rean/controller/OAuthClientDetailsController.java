package com.rean.controller;


import com.rean.model.OAuthClientDetails;
import com.rean.service.OAuthClientDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/oauth/clients")
public class OAuthClientDetailsController {

    private final OAuthClientDetailsService clientDetailsService;

    public OAuthClientDetailsController(OAuthClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    @GetMapping
    public ResponseEntity<Collection<OAuthClientDetails>> getAllClients() {
        return ResponseEntity.ok(clientDetailsService.listClientDetails());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<OAuthClientDetails> getClientById(@PathVariable String clientId) {
        OAuthClientDetails client = clientDetailsService.loadClientByClientId(clientId);
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<OAuthClientDetails> createClient(@RequestBody OAuthClientDetails clientDetails) {
        return ResponseEntity.ok(clientDetailsService.addClientDetails(clientDetails));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<OAuthClientDetails> updateClient(@PathVariable String clientId,
                                                           @RequestBody OAuthClientDetails clientDetails) {

        clientDetails.setClientId(clientId);
        return ResponseEntity.ok(clientDetailsService.updateClientDetails(clientDetails));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable String clientId) {
        clientDetailsService.removeClientDetails(clientId);
        return ResponseEntity.noContent().build();
    }

}
