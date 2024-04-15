package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class AuthorDto {
    @Schema(description = "id")
    private UUID id;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Фото")
    private String photo;
}
