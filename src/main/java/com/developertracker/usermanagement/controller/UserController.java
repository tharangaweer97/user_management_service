package com.developertracker.usermanagement.controller;

import com.developertracker.usermanagement.model.GithubUser;
import com.developertracker.usermanagement.service.GithubUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")

public class UserController {
    private GithubUserService githubUserService;

    @GetMapping("/contributors")
    public ResponseEntity<List<GithubUser>> getGithubUser() {
        return ResponseEntity.ok(this.githubUserService.getGithubUser());
    }

    @GetMapping("/contributors/get-all")
    public ResponseEntity<List<GithubUser>> getAllUsers() {
        return ResponseEntity.ok(this.githubUserService.getAllUsers());
    }
}
