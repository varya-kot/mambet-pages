package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GetArticleFromProfileDto {
    @Schema(description = "Общее количество страниц")
    private int pagesCount = 10;

    @Schema(description = "Статьи")
    private ArticleFromProfileDto[] articlesFromProfile;
}
