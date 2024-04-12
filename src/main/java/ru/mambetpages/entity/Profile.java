package ru.mambetpages.entity;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.UUID;

@Data
public class Profile {
    /**
     * Id пользователя в системе
     */
    UUID id;

    /**
     * Имя пользователя
     */
    String name;

    /**
     * Фамилия пользователя
     */
    String lastName;

    /**
     * Описание профиля
     */
    @Nullable
    String description;

    /**
     * Фотография профиля
     */
    @Nullable
    String photo;

    /**
     * Емайл пользователя
     */
    String email;

    /**
     * Пароль
     */
    String password;

    /**
     * Старый пароль пользователя
     */
    String oldPassword;

    /**
     * Новый пароль пользователя
     */
    String newPassword;

    /**
     * Первый ли это вход пользователя
     */
    boolean firstLogin;
}
