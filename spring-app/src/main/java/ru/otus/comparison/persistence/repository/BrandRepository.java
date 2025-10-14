package ru.otus.comparison.persistence.repository;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.comparison.persistence.entity.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    @NonNull
    Page<BrandEntity> findAll(@NonNull Pageable pageable);

}
