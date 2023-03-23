package com.pieropan.githubsearch.service;

import com.pieropan.githubsearch.dto.RepositoriesDto;
import com.pieropan.githubsearch.dto.UserDto;
import com.pieropan.githubsearch.feignclient.GitHubFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GitHubFeignClient gitHubFeignClient;

    public UserDto searchUserName(String userName) {
        UserDto userDto = gitHubFeignClient.searchUserName(userName);
        userDto.setCreated_at(userDto.getCreated_at().substring(0, 10));
        return userDto;
    }

    public List<RepositoriesDto> getRepositories(String userName) {
        return gitHubFeignClient.searchRepositories(userName);
    }
}