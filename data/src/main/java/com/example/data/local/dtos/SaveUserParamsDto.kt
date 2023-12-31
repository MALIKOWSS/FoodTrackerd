package com.example.data.local.dtos

import com.example.domain.models.SaveUserParams

data class SaveUserParamsDto(
    val nameLogIn: String,
    val booleanOnBoard: Boolean,
    val booleanLogIn: Boolean
)

fun SaveUserParamsDto.toDomain() =
    SaveUserParams(nameLogIn, booleanOnBoard, booleanLogIn)
