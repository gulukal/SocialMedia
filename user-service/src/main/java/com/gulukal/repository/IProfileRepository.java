package com.gulukal.repository;

import com.gulukal.repository.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfileRepository extends MongoRepository<Profile,String> {

    Optional<Profile> findByAuthid(long id);

}
