package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ArticleGetShortDto {
    @Schema(description = "id статьи")
    private UUID id;

    @Schema(description = "Название статьи")
    private String title;

    @Schema(description = "Содержание статьи")
    private String content;

    @Schema(description = "Изображение")
    private String image;

    @Schema(description = "Теги")
    private List<String> tags;

    @Schema(description = "Просмотры")
    private Integer views;

    @Schema(description = "Дата публикации")
    private LocalDateTime publishDate;

    @Schema(description = "Автор")
    private AuthorDto author;
}
