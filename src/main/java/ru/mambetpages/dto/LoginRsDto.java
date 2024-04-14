package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRsDto {


    @Schema(description ="Первый вход")
    private boolean firstLogin;

}
