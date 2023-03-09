package com.Gopal.ChatApplicationProject.service;

import com.Gopal.ChatApplicationProject.dao.StatusRepository;
import com.Gopal.ChatApplicationProject.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    StatusRepository repository;

    public int saveStatus(Status status) {
        Status statusObj = repository.save(status);
        return statusObj.getStatusId();
    }
    public List<Status> getall() {
        return repository.findAll();
    }
}
