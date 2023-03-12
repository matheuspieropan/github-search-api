package com.pieropan.githubsearch.controller;

import com.pieropan.githubsearch.dto.RepositoriesDto;
import com.pieropan.githubsearch.dto.UserDto;
import com.pieropan.githubsearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/user/{userName}")
    public ResponseEntity<?> searchUserName(@PathVariable String userName) {
        try {
            UserDto userDto = searchService.searchUserName(userName);
            return ResponseEntity.ok().body(userDto);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/repositorie/{userName}")
    public ResponseEntity<?> getRepositories(@PathVariable String userName) {
        try {
            List<RepositoriesDto> repositories = searchService.getRepositories(userName);
            return ResponseEntity.ok().body(repositories);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}