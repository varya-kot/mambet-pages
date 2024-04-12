package ru.mambetpages.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.mambetpages.dto.GetProfileDto;
import ru.mambetpages.dto.PutProfileDto;

import java.util.UUID;

@RestController()
@RequestMapping(value = "/api/v1/profiles")
@Tag(name = "Личный кабинет")
public class PersonalProfileController {
    @GetMapping()
    @Operation(summary = "Получение данных о профиле")
    public GetProfileDto getProfile(@RequestParam UUID id) {
        GetProfileDto profileDto = new GetProfileDto();

        profileDto.setName("Имя");
        profileDto.setLastName("Фамилия");
        profileDto.setDescription("Описание профиля");
        profileDto.setPhoto("Фотокарточка");
        profileDto.setEmail("Мыло");

        return profileDto;
    }

    @PutMapping()
    @Operation(summary = "Получение данных о профиле")
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

