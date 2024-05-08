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

    @NotNull(message = "current password must have value")
    String currentPassword;

    @NotNull(message = "new password must have value")
    @Pattern(regexp = PASSWORD_PATTERN, message = PASSWORD_MESSAGE)
    String newPassword;

    @NotNull(message = "confirm new password must have value")
    String confirmNewPassword;

    @JsonIgnore
    @AssertTrue(message = "New password and confirm password must match")
    public boolean isPasswordConfirmed() {
        return newPassword.equals(confirmNewPassword);
    }
}
