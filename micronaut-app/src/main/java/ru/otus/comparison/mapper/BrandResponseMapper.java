package ru.otus.comparison.mapper;

import org.mapstruct.Mapper;
import ru.otus.comparison.api.dto.response.BrandResponse;
import ru.otus.comparison.persistence.entity.BrandEntity;


@Mapper(componentModel = "jsr330")
public interface BrandResponseMapper {

    BrandResponse map(BrandEntity dto);

}


