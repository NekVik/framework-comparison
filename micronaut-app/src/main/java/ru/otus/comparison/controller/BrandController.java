package ru.otus.comparison.controller;

import io.micronaut.http.annotation.Controller;
import jakarta.inject.Inject;
import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.otus.comparison.api.BrandsApi;
import ru.otus.comparison.api.dto.request.BrandPathRequest;
import ru.otus.comparison.api.dto.response.BrandResponse;
import ru.otus.comparison.service.BrandService;


@Controller
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BrandController implements BrandsApi {

    private final BrandService service;

    @Override
    public List<BrandResponse> getBrands() {
        return service.getAll();
    }

    @Override
    public BrandResponse updateBrand(Long id, BrandPathRequest request) {
        return service.update(id, request);
    }

}
