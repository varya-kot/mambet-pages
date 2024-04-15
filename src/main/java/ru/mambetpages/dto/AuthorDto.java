package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AuthorDto {
    @Schema(description = "id")
    private String id;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Фото")
    private String photo;
}
