package com.developertracker.usermanagement.service.external;



import com.developertracker.usermanagement.dto.GithubUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class GithubExternalClient {

    private final RestTemplate restTemplate;

    @Value("${github.user-detail-url}")
    private String gitHubUserDetailsUrl;

    public GithubExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GithubUserDto> getUserDetails() {
        ResponseEntity<List<GithubUserDto>> response = restTemplate.exchange(gitHubUserDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }


}