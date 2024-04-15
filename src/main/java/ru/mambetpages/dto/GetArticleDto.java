package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class GetArticleDto {
    @Schema(description = "Название статьи")
    private String title;

    @Schema(description = "Содержание статьи")
    private String content;

    @Schema(description = "Изображение")
    private String image;

    @Schema(description = "Теги")
    private String[] tags;

    @Schema(description = "Просмотры")
    private int views = 0;

    @Schema(description = "Дата публикации")
    private LocalDateTime publishDate;

    @Schema(description = "Автор")
    private AuthorDto author;
}
