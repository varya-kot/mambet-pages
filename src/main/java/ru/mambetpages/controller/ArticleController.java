package ru.mambetpages.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mambetpages.dto.AuthorDto;
import ru.mambetpages.dto.GetArticleDto;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/articles")
@Tag(name = "Статьи")
public class ArticleController {
    @GetMapping
    @Operation(summary = "Получение данных о статье")
    public GetArticleDto getArticle(@Parameter(description = "id статьи",
            example = "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")
                                        @RequestParam UUID id) {
        GetArticleDto articleDto = new GetArticleDto();
        AuthorDto authorDto = new AuthorDto();

        authorDto.setName("Ицык");
        authorDto.setLastName("Цыпер");
        authorDto.setId("bae588b0-8a55-4c26-bfb4-7dbff0ab0b59");
        authorDto.setPhoto("Фото");

        articleDto.setTitle("Название статьи");
        articleDto.setContent("Содержание статьи");
        articleDto.setTags(new String[]{"Тег статьи", "Еще один тег статьи", "Третий тег статьи", "Последний тег статьи"});
        articleDto.setPublishDate(LocalDateTime.MIN);
        articleDto.setAuthor(authorDto);

        return articleDto;
    }


}
