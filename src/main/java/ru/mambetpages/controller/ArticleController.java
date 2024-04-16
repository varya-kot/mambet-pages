package ru.mambetpages.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mambetpages.dto.AuthorDto;
import ru.mambetpages.dto.GetArticleDto;
import ru.mambetpages.dto.GetArticleShortDto;
import ru.mambetpages.dto.GetArticlesDto;
import ru.mambetpages.dto.PostArticleDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/articles")
@Tag(name = "Статьи")
public class ArticleController {
    @GetMapping("{id}")
    @Operation(summary = "Получение данных о статье")
    public GetArticleDto getArticle(@Parameter(description = "id статьи",
            example = "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")
                                        @PathVariable UUID id) {
        GetArticleDto articleDto = new GetArticleDto();
        AuthorDto authorDto = new AuthorDto();

        authorDto.setName("Ицык");
        authorDto.setLastName("Цыпер");
        authorDto.setId(UUID.randomUUID());
        authorDto.setPhoto("Фото");

        articleDto.setTitle("Название статьи");
        articleDto.setContent("Содержание статьи");
        articleDto.setTags(List.of("Тег статьи", "Еще один тег статьи", "Третий тег статьи", "Последний тег статьи"));
        articleDto.setPublishDate(LocalDateTime.MIN);
        articleDto.setAuthor(authorDto);
        articleDto.setViews(123);

        return articleDto;
    }

    @GetMapping
    @Operation(summary = "Получение списка статей")
    public GetArticlesDto getArticles(@RequestParam("page") int page,
                                      @RequestParam("size") int size) {
        GetArticlesDto articleDto = new GetArticlesDto();
        GetArticleShortDto firstArticle = new GetArticleShortDto();
        GetArticleShortDto secondArticle = new GetArticleShortDto();
        AuthorDto firstAuthorDto = new AuthorDto();
        AuthorDto secondAuthorDto = new AuthorDto();
        List<GetArticleShortDto> articles = new ArrayList<>();

        articles.add(firstArticle);
        articles.add(secondArticle);

        firstAuthorDto.setName("Ицык");
        firstAuthorDto.setLastName("Цыпер");
        firstAuthorDto.setId(UUID.randomUUID());
        firstAuthorDto.setPhoto("Фото");

        secondAuthorDto.setName("Игорь");
        secondAuthorDto.setLastName("Цыба");
        secondAuthorDto.setId(UUID.randomUUID());
        secondAuthorDto.setPhoto("Фото");

        firstArticle.setId(UUID.randomUUID());
        firstArticle.setTitle("Название первой статьи");
        firstArticle.setContent("Содержание первой статьи");
        firstArticle.setImage("Изображение первой статьи");
        firstArticle.setTags(List.of("Тег первой статьи", "Еще один тег первой статьи", "Третий тег первой статьи", "Последний тег первой статьи"));
        firstArticle.setPublishDate(LocalDateTime.MIN);
        firstArticle.setAuthor(firstAuthorDto);
        firstArticle.setViews(111);

        secondArticle.setId(UUID.randomUUID());
        secondArticle.setTitle("Название второй статьи");
        secondArticle.setContent("Содержание второй статьи");
        secondArticle.setImage("Изображение второй статьи");
        secondArticle.setTags(List.of("Тег второй статьи", "Еще один тег второй статьи", "Третий тег второй статьи", "Последний тег второй статьи"));
        secondArticle.setPublishDate(LocalDateTime.MIN);
        secondArticle.setAuthor(secondAuthorDto);
        secondArticle.setViews(222);

        articleDto.setArticles(articles);
        articleDto.setPagesCount(76);

        return articleDto;
    }

    @PostMapping
    @Operation(summary = "Создание новой статьи")
    public PostArticleDto postArticle(@RequestBody PostArticleDto articleDto) {
        PostArticleDto publishArticle = new PostArticleDto();

        publishArticle.setTitle(articleDto.getTitle());
        publishArticle.setContent(articleDto.getContent());
        publishArticle.setImage(articleDto.getImage());
        publishArticle.setTags(articleDto.getTags());

        return publishArticle;
    }
}
