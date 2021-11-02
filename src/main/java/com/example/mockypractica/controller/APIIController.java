package com.example.mockypractica.controller;

import com.example.mockypractica.exception.ResourceNotFoundException;
import com.example.mockypractica.model.API;
import com.example.mockypractica.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIIController {

    @Autowired
    private APIService apiService;
    @GetMapping("/api")
    public List<API> getAllAPI(){
        return apiService.getAPIs();
    }
    // request body covert json object to java obj
    @PostMapping("/api")
    public ResponseEntity<API> saveAPI(@RequestBody API api){
        return new ResponseEntity<API>(apiService.saveAPI(api), HttpStatus.CREATED);
    }

    @PutMapping("/api/{id}")
    public ResponseEntity<API> updateAPI(@RequestBody API api, @PathVariable("id") long id) throws ResourceNotFoundException {
        api.setId(id);
        return new ResponseEntity<API>(apiService.updateAPI(api),HttpStatus.CREATED);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<String> deleteAPI(@PathVariable("id") long id) throws ResourceNotFoundException{
        apiService.deleteAPI(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);

    }

}
