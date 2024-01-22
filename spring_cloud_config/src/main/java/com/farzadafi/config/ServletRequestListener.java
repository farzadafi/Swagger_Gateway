package com.farzadafi.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServletRequestListener implements jakarta.servlet.ServletRequestListener {