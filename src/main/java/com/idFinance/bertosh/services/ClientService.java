package com.idFinance.bertosh.services;

import com.idFinance.bertosh.constants.Status;
import com.idFinance.bertosh.model.Request;
import com.idFinance.bertosh.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private RequestRepository repository;

    public Request save(Request request) {
        request.setStatus(Status.UNDER_CONSIDERATION);
        request = repository.save(request);
        return request;
    }
}
