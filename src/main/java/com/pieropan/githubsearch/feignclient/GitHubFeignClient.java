package com.pieropan.githubsearch.feignclient;

import com.pieropan.githubsearch.dto.RepositoriesDto;
import com.pieropan.githubsearch.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "search", url = "https://api.github.com")
public interface GitHubFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userName}")
    UserDto searchUserName(@PathVariable String userName);

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userName}/repos")
    List<RepositoriesDto> searchRepositories(@PathVariable String userName);
}