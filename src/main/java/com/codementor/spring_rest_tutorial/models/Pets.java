package com.codementor.spring_rest_tutorial.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Pets {
    
    // primary identifier
    @Id
    public ObjectId _id;    
    
    public String name;
    public String species;
    public String breed;
    
    // Constructors 
    public Pets(){}
    
    public Pets(ObjectId _id, String name, String species, String breed ){
        this._id = _id;
        this.name = name;
        this.species = species;
        this.breed = breed;
    }
    
    // ObjectId needs to be converted to string
    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    
}
