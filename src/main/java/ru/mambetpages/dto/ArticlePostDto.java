package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Data
public class ArticlePostDto {
    @NotBlank
    @Schema(description = "Название статьи")
    private String title;

    @NotBlank
    @Schema(description = "Содержание статьи")
    private String content;

    @Schema(description = "Изображение")
    private String image;

    @NotBlank
    @Schema(description = "Теги")
    private List<String> tags;
}
