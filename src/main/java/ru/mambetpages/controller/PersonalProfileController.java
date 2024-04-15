package ru.mambetpages.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mambetpages.dto.GetProfileDto;
import ru.mambetpages.dto.LoginDto;
import ru.mambetpages.dto.LoginRsDto;
import ru.mambetpages.dto.PutProfileDto;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/profiles")
@Tag(name = "Личный кабинет")
public class PersonalProfileController {
    @GetMapping
    @Operation(summary = "Получение данных о профиле")
    public GetProfileDto getProfile(@Parameter(description = "Айди профиля",
            example = "bae588b0-8a55-4c26-bfb4-7dbff0ab0b59")
                                    @RequestParam UUID id) {
        GetProfileDto profileDto = new GetProfileDto();

        profileDto.setName("Имя");
        profileDto.setLastName("Фамилия");
        profileDto.setDescription("Описание профиля");
        profileDto.setPhoto("Фотокарточка");
        profileDto.setEmail("Мыло");

        return profileDto;
    }

    @PutMapping
    @Operation(summary = "Изменение данных профиля")
    public GetProfileDto putProfile(@RequestBody PutProfileDto profile) {
        GetProfileDto profileDto = new GetProfileDto();

        profileDto.setName(profile.getName());
        profileDto.setLastName(profile.getLastName());
        profileDto.setDescription(profile.getDescription());
        profileDto.setPhoto(profile.getPhoto());
        profileDto.setName("Мыло");

        return profileDto;
    }

    @PostMapping
    @Operation(
            summary = """
                    Вход в профиль
                    Вася вошел в первый раз
                    Петя вошел в 3 раз
                    Егор не может авторизоваться
                    У остальных ошибка 500
                    """
    )
    public ResponseEntity<?> login(@RequestBody LoginDto login) {
        System.out.println(login);
        LoginRsDto loginDto = new LoginRsDto();

        switch (login.getEmail()) {
            case "Вася":
                loginDto.setFirstLogin(true);
                return ResponseEntity.ok(loginDto);
            case "Петя":
                loginDto.setFirstLogin(false);
                return ResponseEntity.ok(loginDto);
            case "Егор":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    @Operation(summary = "Выход из профиля")
    public void logout() {
    }
}
