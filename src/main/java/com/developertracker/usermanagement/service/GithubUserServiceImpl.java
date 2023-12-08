package com.developertracker.usermanagement.service;


import com.developertracker.usermanagement.dto.GithubUserDto;
import com.developertracker.usermanagement.model.GithubUser;
import com.developertracker.usermanagement.repository.GitHubUserRepository;
import com.developertracker.usermanagement.service.external.GithubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GithubUserServiceImpl implements GithubUserService {

    private final GithubExternalClient githubExternalClient;
    private final GitHubUserRepository gitHubUserRepository;

    @Override
    public List<GithubUser> getGithubUser() {
        List<GithubUser> githubUsers = new ArrayList<>();

        List<GithubUserDto> githubUserDtoList = this.githubExternalClient.getUserDetails();
        githubUserDtoList.forEach(githubUserDto -> {
            GithubUser githubUser = this.generateGitHubUserObject(githubUserDto);
            githubUsers.add(githubUser);
        });

        this.gitHubUserRepository.saveAll(githubUsers);

        return githubUsers;


    }

    @Override
    public List<GithubUser> getAllUsers() {
        return this.gitHubUserRepository.findAll();
    }

    private GithubUser generateGitHubUserObject(GithubUserDto githubUserDto) {
        return GithubUser.builder()
                .gitHubId(githubUserDto.getId())
                .login(githubUserDto.getLogin())
                .contributions(githubUserDto.getContributions())
                .type(githubUserDto.getType())
                .siteAdmin(githubUserDto.isSiteAdmin())
                .reposUrl(githubUserDto.getReposUrl())
                .nodeId(githubUserDto.getNodeId())
                .build();
    }

}