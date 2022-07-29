package com.example.CartiqueMySQL.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class ClientDto {
    @Id
    private Integer id;
    private String name;
    private String email;
    private long mobile;
    private String gender;
    private String password;
}
