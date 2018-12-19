package com.codementor.spring_rest_tutorial.repositories;

import com.codementor.spring_rest_tutorial.models.Pets;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author nkengasong
 */
public interface PetsRepository extends MongoRepository<Pets, String> {

    Pets findBy_id(ObjectId _id);
}
