package com.capibaracode.backend.infraestructure.abstract_services;

import com.capibaracode.backend.api.models.requests.ClientRequest;
import com.capibaracode.backend.common.CustomAPIResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IClientService {
    ResponseEntity<CustomAPIResponse<?>> findAll();
    ResponseEntity<CustomAPIResponse<?>> findAllOnlyActive();
    ResponseEntity<CustomAPIResponse<?>> findById(UUID id);
    ResponseEntity<CustomAPIResponse<?>> save(ClientRequest client);
    ResponseEntity<CustomAPIResponse<?>> update(UUID id, ClientRequest client);
    ResponseEntity<CustomAPIResponse<?>> changeStatus(UUID id);

}
