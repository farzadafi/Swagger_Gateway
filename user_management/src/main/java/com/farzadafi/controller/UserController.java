package com.farzadafi.controller;

import com.farzadafi.dto.*;
import com.farzadafi.model.User;
import com.farzadafi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@PreAuthorize("@tokenClaimsValidator.checkAuthorize('USER')")
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<UserResponseDto> register(@RequestBody @Valid UserSaveRequestDto userSaveRequestDto) {
        User user = mapper.map(userSaveRequestDto, User.class);
        user = userService.registerUser(user);
        UserResponseDto userDtoAfterSaved = mapper.map(user, UserResponseDto.class);
        return new ResponseEntity<>(userDtoAfterSaved, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> update(@RequestBody UserUpdateRequestDto userUpdateRequestDto) {
        User userUpdate = userService.update(userUpdateRequestDto);
        UserResponseDto userAfterUpdate = mapper.map(userUpdate, UserResponseDto.class);
        return new ResponseEntity<>(userAfterUpdate, HttpStatus.OK);
    }

}
