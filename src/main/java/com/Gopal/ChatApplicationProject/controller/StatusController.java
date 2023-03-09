package com.Gopal.ChatApplicationProject.controller;

import com.Gopal.ChatApplicationProject.model.Status;
import com.Gopal.ChatApplicationProject.service.ChatHistoryService;
import com.Gopal.ChatApplicationProject.service.StatusService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/status")
public class StatusController {
    @Autowired
    StatusService service;
    @PostMapping("/create-status")
    public ResponseEntity<String> createStatus(@RequestBody String statusData) {
        Status status = setStatus(statusData);
        int statusId = service.saveStatus(status);
        return new ResponseEntity<>("Status Created with Status id - " + statusId, HttpStatus.CREATED);
    }

    private Status setStatus(String statusData) {
        //Create new status object
        Status status = new Status();
        /*
        statusData has data type as String but format is JSON, so we create object of json then send
        the String to Json and the convert it to status object.
        */
        JSONObject json = new JSONObject(statusData);
        String statusName = json.getString("statusName");
        String statusDescription = json.getString("statusDescription");
        status.setStatusName(statusName);
        status.setStatusDescription(statusDescription);
        return status;
    }
    @GetMapping("/show-all-status")
    public List<Status> getall(){
        return service.getall();
    }


}
