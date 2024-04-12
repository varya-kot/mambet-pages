package ru.mambetpages.mapper;

import org.mapstruct.Mapper;
import ru.mambetpages.dto.GetProfileDto;
import ru.mambetpages.entity.Profile;

@Mapper
public interface GetProfileMapper {
    Profile toModel(GetProfileDto dto);

    GetProfileDto toDto(Profile model);
}
