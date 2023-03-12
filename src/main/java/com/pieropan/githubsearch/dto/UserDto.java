package com.pieropan.githubsearch.dto;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String login;
    private String location;
    private String avatar_url;
    private String html_url;
    private String created_at;
    private String repos_url;
    private String bio;
}