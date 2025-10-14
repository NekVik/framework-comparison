package ru.otus.comparison.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping(PATH)
    List<BrandResponse> getBrands();

    @Operation(method = "path", summary = "Обновление бренда")
    @ApiResponse(
        description = "Список брендов",
        responseCode = "200",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = BrandResponse.class))
        ))
    @PatchMapping(PATH + "/{id}")
    BrandResponse updateBrand(@PathVariable Long id, @Valid @RequestBody BrandPathRequest request);

}
