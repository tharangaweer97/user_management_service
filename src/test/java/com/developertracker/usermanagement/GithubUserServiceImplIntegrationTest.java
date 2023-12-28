package com.developertracker.usermanagement;

import com.developertracker.usermanagement.dto.GithubUserDto;
import com.developertracker.usermanagement.model.GithubUser;
import com.developertracker.usermanagement.repository.GitHubUserRepository;
import com.developertracker.usermanagement.service.GithubUserServiceImpl;
import com.developertracker.usermanagement.service.external.GithubExternalClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

    public class GithubUserServiceImplIntegrationTest {

        @Test
        public void testGetGithubUser() {
            // Mock the GitHubExternalClient and GitHubUserRepository
            GithubExternalClient gitHubExternalClient = Mockito.mock(GithubExternalClient.class);
            GitHubUserRepository gitHubUserRepository = Mockito.mock(GitHubUserRepository.class);

            // Create an instance of GitHubUserServiceImpl with the mock dependencies
            GithubUserServiceImpl gitHubUserService = new GithubUserServiceImpl(gitHubExternalClient, gitHubUserRepository);

            // Mock data for the GitHubExternalClient response
            List<GithubUserDto> mockGitHubUserDtoList = Arrays.asList(
                    new GithubUserDto("user1", 1, "nodeId1", "avatarUrl1", "gravatarId1", "url1", "htmlUrl1", "followersUrl1",
                            "followingUrl1", "gistsUrl1", "starredUrl1", "subscriptionsUrl1", "organizationsUrl1",
                            "reposUrl1", "eventsUrl1", "receivedEventsUrl1", "type1", false, 10),
                    new GithubUserDto("user2", 2, "nodeId2", "avatarUrl2", "gravatarId2", "url2", "htmlUrl2", "followersUrl2",
                            "followingUrl2", "gistsUrl2", "starredUrl2", "subscriptionsUrl2", "organizationsUrl2",
                            "reposUrl2", "eventsUrl2", "receivedEventsUrl2", "type2", true, 15)
                    // Add more mock data as needed
            );

            // Mock the behavior of the GitHubExternalClient when getUserDetails is called
            when(gitHubExternalClient.getUserDetails()).thenReturn(mockGitHubUserDtoList);

            // Mock the behavior of the GitHubUserRepository when saveAll is called
            when(gitHubUserRepository.saveAll(Mockito.anyList()))
                    .thenAnswer(invocation -> {
                        List<GithubUser> savedUsers = invocation.getArgument(0);  // Capture the argument
                        // You may need to convert savedUsers to GitHubUserDto before saving
                        return savedUsers;
                    });

            // Call the method to be tested
            List<GithubUser> result = gitHubUserService.getGithubUser();

            // Perform assertions based on your expected behavior
            assertEquals(mockGitHubUserDtoList.size(), result.size());
            // Add more assertions as needed
        }

        // Add more integration tests as needed for other methods in GitHubUserServiceImpl
    }

