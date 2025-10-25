package ru.otus.comparison.persistence.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import lombok.NonNull;
import ru.otus.comparison.persistence.entity.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    @NonNull
    Page<BrandEntity> findAll(@NonNull Pageable pageable);

}
