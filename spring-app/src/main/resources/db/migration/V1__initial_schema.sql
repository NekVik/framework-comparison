CREATE TABLE pm_external_brand (
	brand_id bigserial NOT NULL,
	brand_name varchar(255) NULL,
	brand_common varchar(255) NULL,
	date_updated timestamp NULL,
	"new" bool DEFAULT false NULL,
	CONSTRAINT pm_external_brand_pkey PRIMARY KEY (brand_id)
);