package ru.otus.comparison.service;

import io.micronaut.data.model.Sort;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.otus.comparison.api.dto.request.BrandPathRequest;
import ru.otus.comparison.api.dto.response.BrandResponse;
import ru.otus.comparison.mapper.BrandEntityMapper;
import ru.otus.comparison.mapper.BrandResponseMapper;
import ru.otus.comparison.persistence.repository.BrandRepository;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BrandService {

    private final BrandRepository repository;
    private final BrandResponseMapper responseMapper;
    private final BrandEntityMapper entityMapper;

    public List<BrandResponse> getAll() {

        var list = repository.findAll(Sort.of(Sort.Order.asc("id")));

        return list.stream().map(responseMapper::map).toList();

    }

    @Transactional
    public BrandResponse update(Long id, BrandPathRequest request) {

        var entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        entityMapper.map(request, entity);

        repository.save(entity);

        return responseMapper.map(entity);

    }
}
