package com.idFinance.bertosh.services;

import com.idFinance.bertosh.constants.Status;
import com.idFinance.bertosh.model.Request;
import com.idFinance.bertosh.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminService {

    @Autowired
    private RequestRepository repository;

    public Request completeRequest(Long id) {
        Optional<Request> request = repository.findById(id);
        if (request.isPresent()) {
            request.get().setStatus(Status.COMPLETED);
            repository.saveAndFlush(request.get());
            return request.get();
        } else {
            return null;
        }
    }

    public Request refuseRequest(Long id) {
        Optional<Request> request = repository.findById(id);
        if (request.isPresent()) {
            request.get().setStatus(Status.REFUSED);
            repository.saveAndFlush(request.get());
            return request.get();
        } else {
            return null;
        }
    }
}
