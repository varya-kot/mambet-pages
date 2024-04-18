package ru.mambetpages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

@Data
public class ArticlesGetDto {
    @Schema(description = "Общее количество страниц")
    private Integer pagesCount;

    @Schema(description = "Статьи")
    private List<ArticleGetShortDto> articles;
}
