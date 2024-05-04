package com.farzadafi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static com.farzadafi.utility.Constant.PASSWORD_MESSAGE;
import static com.farzadafi.utility.Constant.PASSWORD_PATTERN;

@SuppressWarnings("unused")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangePasswordDto {

    String currentPassword;

    String newPassword;

    String confirmNewPassword;
}
