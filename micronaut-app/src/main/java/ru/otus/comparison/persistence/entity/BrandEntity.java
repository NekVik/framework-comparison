package ru.otus.comparison.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Setter
@Getter
@Table(name = "pm_external_brand")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;

    @Column(name = "brand_name")
    private String name;

    @Column(name = "brand_common")
    private String common;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private Instant dateUpdated;

    @Column(name = "new")
    private Boolean isNew;

}
