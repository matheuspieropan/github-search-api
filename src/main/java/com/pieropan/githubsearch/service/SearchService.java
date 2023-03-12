package com.pieropan.githubsearch.service;

import com.pieropan.githubsearch.dto.RepositoriesDto;
import com.pieropan.githubsearch.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.HttpMethod.GET;

@Service
public class SearchService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${url.github.user}")
    String url;

    @Value("${url.github.repo}")
    String repositories;

    public UserDto searchUserName(String userName) {
        UserDto userDto = restTemplate.exchange(url.concat(userName), GET, null, UserDto.class).getBody();
        userDto.setCreated_at(userDto.getCreated_at().substring(0, 10));
        return userDto;
    }

    public List<RepositoriesDto> getRepositories(String userName) {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForEntity(
                repositories.replace("?", userName), RepositoriesDto[].class).getBody()));
    }
}