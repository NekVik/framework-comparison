package ru.otus.comparison.api.dto.response;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;


@Builder
@Getter
@Serdeable
@Jacksonized
@Schema(description = "Информация о бренде")
public class BrandResponse {

    @Schema(description = "Идентификатор")
    private Long id;

    @Schema(description = "Справочное название")
    private String name;

    @Schema(description = "Новое название")
    private String common;

    @Schema(description = "Дата и время обновления")
    private Instant dateUpdated;

    @Schema(description = "Признак \"Новый\"")
    private Boolean isNew;

}
