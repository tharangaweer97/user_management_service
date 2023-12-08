package com.developertracker.usermanagement.service;

import com.developertracker.usermanagement.model.GithubUser;

import java.util.List;

public interface GithubUserService {
    List<GithubUser> getGithubUser();

    List<GithubUser> getAllUsers();
}
