package com.pieropan.githubsearch.controller;

import com.pieropan.githubsearch.dto.RepositoriesDto;
import com.pieropan.githubsearch.dto.UserDto;
import com.pieropan.githubsearch.feignclient.GitHubFeignClient;
import com.pieropan.githubsearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @CrossOrigin(origins = "https://pieropan.vercel.app/")
    @GetMapping(value = "/user/{userName}")
    public ResponseEntity<?> searchUserName(@PathVariable String userName) {
        UserDto userDto = searchService.searchUserName(userName);
        return ResponseEntity.ok().body(userDto);
    }

    @CrossOrigin(origins = "https://pieropan.vercel.app/")
    @GetMapping(value = "/repositorie/{userName}")
    public ResponseEntity<?> getRepositories(@PathVariable String userName) {
        List<RepositoriesDto> repositories = searchService.getRepositories(userName);
        return ResponseEntity.ok().body(repositories);
    }
}