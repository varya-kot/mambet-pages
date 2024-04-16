package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PostArticleDto {
    @Schema(description = "Название статьи")
    private String title;

    @Schema(description = "Содержание статьи")
    private String content;

    @Schema(description = "Изображение")
    private String image;

    @Schema(description = "Теги")
    private List<String> tags;
}
