package com.codementor.spring_rest_tutorial.controllers;
// A REST Controller uses Request Mappings to map requests with functions

import com.codementor.spring_rest_tutorial.models.Pets;
import com.codementor.spring_rest_tutorial.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetsRepository repository;

    // GET
    // Requests to the host with a URL of /pets/ and maps them to the getAllPets()
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Pets> getAllPets() {
        return repository.findAll();
    }
    
    // GET
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    // PUT
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
        pets.setId(id);
        repository.save(pets);
    }

    // POST
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Pets createPet(@Valid @RequestBody Pets pets) {
        pets.setId(ObjectId.get());
        repository.save(pets);
        return pets;
    }

    // DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

}
