package com.developertracker.usermanagement.repository;

import com.developertracker.usermanagement.model.GithubUser;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface GitHubUserRepository extends MongoRepository<GithubUser, String> {

}