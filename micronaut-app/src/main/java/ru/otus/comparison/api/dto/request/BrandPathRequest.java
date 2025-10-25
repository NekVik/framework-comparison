package ru.otus.comparison.api.dto.request;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Serdeable
@Schema(description = "Обновление бренда")
public class BrandPathRequest {

    @NotBlank
    @Schema(description = "Новое название")
    String common;

}
