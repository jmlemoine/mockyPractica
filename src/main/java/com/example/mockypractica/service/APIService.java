package com.example.mockypractica.service;

import com.example.mockypractica.exception.ResourceNotFoundException;
import com.example.mockypractica.model.API;
import com.example.mockypractica.repository.APIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class APIService {

    @Autowired
    private APIRepository apiRepository;

    public API saveAPI(API api) {
        return apiRepository.save(api);
    }

    public List<API> getAPIs() {
        return apiRepository.findAll();
    }

    public API updateAPI(API api) throws ResourceNotFoundException {
        Optional<API> api_new = apiRepository.findById(api.getId());
        if (!api_new.isPresent()) {
            throw new ResourceNotFoundException("Resource Not Found!!!!");
        }
        else {
            API api1 = api_new.get();
            api1.setIdd(api.getIdd());
            api1.setName(api.getName());
            api1.setEmail(api.getEmail());
            apiRepository.save(api1);
            return api1;
        }
    }

    public API getAPIById(long id) throws ResourceNotFoundException {
        Optional<API> api_new = apiRepository.findById(id);
        if (!api_new.isPresent()) {
            throw new ResourceNotFoundException("Resource Not Found!!!!");
        }
        else {
            return api_new.get();
        }
    }

    public void deleteAPI(long id) throws ResourceNotFoundException {
        Optional<API> api_new = apiRepository.findById(id);
        if (!api_new.isPresent()) {
            throw new ResourceNotFoundException("Resource Not Found!!!!");
        }
        else {
            apiRepository.delete(api_new.get());
        }
    }

}
