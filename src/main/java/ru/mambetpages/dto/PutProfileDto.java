package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PutProfileDto {
    @Schema(description ="Имя пользователя")
    private String name;

    @Schema(description ="Фамилия пользователя")
    private String lastName;

    @Schema(description = "Описание профиля")
    private String description;

    @Schema(description = "Фотография профиля")
    private String photo;
}
