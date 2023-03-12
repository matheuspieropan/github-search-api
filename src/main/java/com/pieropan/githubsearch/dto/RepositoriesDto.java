package com.pieropan.githubsearch.dto;

import lombok.Data;

@Data
public class RepositoriesDto {
    private String name;
    private String full_name;
    private String html_url;
    private String created_at;
}