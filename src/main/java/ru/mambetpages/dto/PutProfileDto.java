package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PutProfileDto {
    @Schema(name = "Имя пользователя")
    String name;

    @Schema(name = "Фамилия пользователя")
    String lastName;

    @Schema(name = "Описание профиля")
    String description;

    @Schema(name = "Фотография профиля")
    String photo;
}
