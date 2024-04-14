package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginDto {

    @Schema(description = "E-mail")
    private String email;

    @Schema(description = "Пароль")
    private String password;

}
