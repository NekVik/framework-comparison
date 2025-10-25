package ru.otus.comparison.api;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import ru.otus.comparison.api.dto.request.BrandPathRequest;
import ru.otus.comparison.api.dto.response.BrandResponse;


@Tag(name = "Управление списком брендов", description = "API для управления списком брендов")
public interface BrandsApi {

    String PATH = "/brands";

    @Operation(summary = "Получение списка брендов")
    @ApiResponse(
        description = "Список брендов",
        responseCode = "200",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = BrandResponse.class))
        ))
    @Get(PATH)
    List<BrandResponse> getBrands();

    @Operation(method = "path", summary = "Обновление бренда")
    @ApiResponse(
        description = "Список брендов",
        responseCode = "200",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = BrandResponse.class))
        ))
    @Patch(PATH + "/{id}")
    BrandResponse updateBrand(@PathVariable Long id, @Valid @Body BrandPathRequest request);

}
