package com.workshopdb.Workshop_mongodb.repository;

import com.workshopdb.Workshop_mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoository extends MongoRepository<User,String> {

}