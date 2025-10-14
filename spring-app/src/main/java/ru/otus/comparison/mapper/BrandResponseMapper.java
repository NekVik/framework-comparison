package ru.otus.comparison.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.otus.comparison.api.dto.response.BrandResponse;
import ru.otus.comparison.persistence.entity.BrandEntity;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BrandResponseMapper {

    BrandResponse map(BrandEntity dto);

}


