package ru.otus.comparison.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.otus.comparison.api.dto.request.BrandPathRequest;
import ru.otus.comparison.persistence.entity.BrandEntity;

@Mapper(componentModel = "jsr330")
public interface BrandEntityMapper {

    @Mapping(target = "isNew", expression = "java(false)")
    void map(BrandPathRequest request, @MappingTarget BrandEntity entity);

}
