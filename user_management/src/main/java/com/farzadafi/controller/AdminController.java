package com.farzadafi.controller;

import com.farzadafi.dto.AdminUpdateUserRequestDto;
import com.farzadafi.dto.ResponseDto;
import com.farzadafi.dto.UserResponseDto;
import com.farzadafi.model.User;
import com.farzadafi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register/admin")
@PreAuthorize("@tokenClaimsValidator.checkAuthorize('ADMIN')")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final ModelMapper mapper;

    @PutMapping("/update-user")
    public ResponseEntity<UserResponseDto> update(@RequestBody AdminUpdateUserRequestDto adminUpdateUserRequestDto) {
        User userUpdate = userService.adminUpdate(adminUpdateUserRequestDto);
        UserResponseDto userAfterUpdate = mapper.map(userUpdate, UserResponseDto.class);
        return new ResponseEntity<>(userAfterUpdate, HttpStatus.OK);
    }
}
