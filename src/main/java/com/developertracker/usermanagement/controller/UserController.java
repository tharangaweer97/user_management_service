package com.developertracker.usermanagement.controller;

import com.developertracker.usermanagement.model.GithubUser;
import com.developertracker.usermanagement.service.GithubUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
https://api.github.com/repos/slatedocs/slate/contributors

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
    public ResponseEntity<List<GitHubContributor>> getAllContributors() {
        return ResponseEntity.ok(this.gitHubContributorService.getAllContributors());
    }
}
