package com.example.uberprojectauthservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private String id;
    private String email;

    private String name;

    private String phoneNumber;

    private String password;

    private Date createdAt;
}
