package com.example.demo.implementation;

import com.example.demo.dtos.WardDto;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Ward;
import com.example.demo.repositories.WardRepository;
import com.example.demo.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WardServiceImplem implements WardService {

    private String baseUrl="http://localhost:8080/ward";

    @Autowired
    private WardRepository wardRepository;

    @Override
    public Ward getWardById(Integer warid) {
        RestTemplate wardRest = new RestTemplate();
        WardDto ward = wardRest.getForObject(baseUrl + "/" +warid,WardDto.class);
        Ward mappedWard = new Ward();
        mappedWard.setCapacity(ward.getCapacity());
        mappedWard.setName(ward.getName());
        mappedWard.setId(ward.getId());
        return mappedWard;

    }
}
