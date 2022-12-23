package com.example.demo.implementation;

import com.example.demo.dtos.PersonDto;
import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonServiceImplem implements PersonService {
    private String baseUrl="http://localhost:8081/person";


    @Override
    public Person getPersonById(Integer pid) {
        RestTemplate personRest = new RestTemplate();
        PersonDto person = personRest.getForObject(baseUrl + "/" + pid,PersonDto.class);
        Person mappedPerson = new Person();
        mappedPerson.setAddress(person.getAddress());
        mappedPerson.setBirthDate(person.getBirthDate());
        mappedPerson.setFirstName(person.getFirstName());
        mappedPerson.setGender(person.getGender());
        mappedPerson.setJmbg(person.getJmbg());
        mappedPerson.setLastName(person.getLastName());
        mappedPerson.setPhone(person.getPhone());
        mappedPerson.setId(person.getId());
        return  mappedPerson;

    }
}
