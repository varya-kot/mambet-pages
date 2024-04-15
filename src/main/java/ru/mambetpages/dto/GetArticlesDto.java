package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

@Data
public class GetArticlesDto {
    @Schema(description = "Общее количество страниц")
    private Integer pagesCount;

    @Schema(description = "Статьи")
    private List<GetArticleShortDto> articles;
}
