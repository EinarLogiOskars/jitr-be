CREATE TABLE business_details (
    id SERIAL PRIMARY KEY,
    business_name VARCHAR(255) NOT NULL,
    business_address VARCHAR(255) NOT NULL,
    tax_id VARCHAR(255) NOT NULL UNIQUE,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE properties (
    id SERIAL PRIMARY KEY,
    business_id BIGINT NOT NULL,
    property_name VARCHAR(255) NOT NULL,
    property_address VARCHAR(255) NOT NULL,
    property_phone VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    FOREIGN KEY (business_id) REFERENCES business_details(id)
);
