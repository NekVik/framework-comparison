package ru.otus.comparison.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.comparison.api.BrandsApi;
import ru.otus.comparison.api.dto.request.BrandPathRequest;
import ru.otus.comparison.api.dto.response.BrandResponse;
import ru.otus.comparison.service.BrandService;


@RestController
@RequiredArgsConstructor
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
