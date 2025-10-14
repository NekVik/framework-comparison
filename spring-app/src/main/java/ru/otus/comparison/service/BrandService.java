package ru.otus.comparison.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.comparison.api.dto.request.BrandPathRequest;
import ru.otus.comparison.api.dto.response.BrandResponse;
import ru.otus.comparison.mapper.BrandEntityMapper;
import ru.otus.comparison.mapper.BrandResponseMapper;
import ru.otus.comparison.persistence.repository.BrandRepository;


@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository repository;
    private final BrandResponseMapper responseMapper;
    private final BrandEntityMapper entityMapper;

    public List<BrandResponse> getAll() {

        var list = repository.findAll(Sort.by("id"));

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
