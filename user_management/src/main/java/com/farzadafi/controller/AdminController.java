package com.farzadafi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register/admin")
@PreAuthorize("@tokenClaimsValidator.checkAuthorize('ADMIN')")
@RequiredArgsConstructor
public class AdminController {
}
