package com.farzadafi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminUpdateUserRequestDto {
    Long id;

    String email;

    String username;

    String firstName;

    String lastName;

    String phoneNumber;

    String nationalCode;

    Boolean isActive;

    Boolean isBlock;

    String avatar;

    String about;
}
