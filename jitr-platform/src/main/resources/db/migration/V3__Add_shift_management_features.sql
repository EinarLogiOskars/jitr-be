CREATE TYPE shift_status AS ENUM (
    'UNFILLED',
    'FILLED',
    'IN_PROGRESS',
    'ENDED',
    'CANCELLED',
    'CONFIRMED',
    'NO_SHOW'
);

CREATE TABLE work_types (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE user_work_type (
    user_id BIGINT NOT NULL,
    work_type_id INT NOT NULL,
    PRIMARY KEY (user_id, work_type_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (work_type_id) REFERENCES work_types(id)
);

CREATE TABLE shifts (
    id SERIAL PRIMARY KEY,
    work_type_id INT NOT NULL,
    property_id BIGINT NOT NULL,
    filled_by_user_id BIGINT,
    shift_details VARCHAR(255) NOT NULL,
    estimated_shift_start TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    shift_start TIMESTAMP WITHOUT TIME ZONE,
    estimated_shift_end TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    shift_end TIMESTAMP WITHOUT TIME ZONE,
    status shift_status NOT NULL DEFAULT 'UNFILLED',
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    FOREIGN KEY (work_type_id) REFERENCES work_types(id),
    FOREIGN KEY (property_id) REFERENCES properties(id),
    FOREIGN KEY (filled_by_user_id) REFERENCES users(id)
);

INSERT INTO work_types (description) VALUES
('Waiter'),
('Bartender'),
('Barista'),
('Caretaker'),
('Housekeeper'),
('Cleaning');

CREATE TABLE shift_interest (
    id SERIAL PRIMARY KEY,
    shift_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    declared_interest_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    FOREIGN KEY (shift_id) REFERENCES shifts(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE (shift_id, user_id)
);
