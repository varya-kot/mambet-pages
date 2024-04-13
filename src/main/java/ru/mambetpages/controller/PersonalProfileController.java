package ru.mambetpages.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.mambetpages.dto.GetProfileDto;
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
}
