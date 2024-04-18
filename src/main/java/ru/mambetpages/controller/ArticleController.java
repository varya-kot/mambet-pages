package ru.mambetpages.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mambetpages.dto.AuthorDto;
import ru.mambetpages.dto.ArticleGetDto;
import ru.mambetpages.dto.ArticleShortGetDto;
import ru.mambetpages.dto.ArticlesGetDto;
import ru.mambetpages.dto.ArticlePostDto;
import ru.mambetpages.dto.ArticlePutDto;
import java.net.URI;
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
    public ArticleGetDto getArticle(@Parameter(description = "id статьи",
            example = "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")
                                        @PathVariable UUID id) {
        ArticleGetDto articleDto = new ArticleGetDto();
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
    public ArticlesGetDto getArticles(@RequestParam("page") int page,
                                      @RequestParam("size") int size) {
        ArticlesGetDto articleDto = new ArticlesGetDto();
        ArticleShortGetDto firstArticle = new ArticleShortGetDto();
        ArticleShortGetDto secondArticle = new ArticleShortGetDto();
        AuthorDto firstAuthorDto = new AuthorDto();
        AuthorDto secondAuthorDto = new AuthorDto();
        List<ArticleShortGetDto> articles = new ArrayList<>();

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
        firstArticle.setTags(List.of(
                "Тег первой статьи",
                "Еще один тег первой статьи",
                "Третий тег первой статьи",
                "Последний тег первой статьи"));
        firstArticle.setPublishDate(LocalDateTime.MIN);
        firstArticle.setAuthor(firstAuthorDto);
        firstArticle.setViews(111);

        secondArticle.setId(UUID.randomUUID());
        secondArticle.setTitle("Название второй статьи");
        secondArticle.setContent("Содержание второй статьи");
        secondArticle.setImage("Изображение второй статьи");
        secondArticle.setTags(List.of(
                "Тег второй статьи",
                "Еще один тег второй статьи",
                "Третий тег второй статьи",
                "Последний тег второй статьи"));
        secondArticle.setPublishDate(LocalDateTime.MIN);
        secondArticle.setAuthor(secondAuthorDto);
        secondArticle.setViews(222);

        articleDto.setArticles(articles);
        articleDto.setPagesCount(76);

        return articleDto;
    }

    @PostMapping
    @Operation(summary = "Создание новой статьи")
    public ResponseEntity<?> postArticle(@Valid @RequestBody ArticlePostDto articleDto) {
        UUID articleId = UUID.randomUUID();
        return ResponseEntity.created(URI.create("/api/v1/articles/" + articleId)).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Редактирование статьи")
    public ArticleGetDto putArticle(@RequestBody ArticlePutDto articleDto,
                                    @PathVariable UUID id) {
        ArticleGetDto getArticle = new ArticleGetDto();
        AuthorDto author = new AuthorDto();

        author.setId(id);
        author.setName("Вася");
        author.setLastName("Пупкин");
        author.setPhoto("Фото автора");

        articleDto.setTitle("Название статьи");
        articleDto.setContent("Содержание статьи");
        articleDto.setImage("Изображение статьи");
        articleDto.setTags(List.of(
                "Первый тег",
                "Второй тег"
        ));

        getArticle.setTitle(articleDto.getTitle());
        getArticle.setContent(articleDto.getContent());
        getArticle.setImage(articleDto.getImage());
        getArticle.setTags(articleDto.getTags());
        getArticle.setViews(555);
        getArticle.setPublishDate(LocalDateTime.now());
        getArticle.setAuthor(author);

        return getArticle;
    }
}
