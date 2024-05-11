CREATE TYPE shift_status AS ENUM (
    'unfilled',
    'filled',
    'in_progress',
    'ended',
    'cancelled',
    'confirmed',
    'no_show'
)

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
    business_id BIGINT NOT NULL,
    shift_details VARCHAR(255) NOT NULL,
    shift_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    estimated_shift_end TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    shift_end TIMESTAMP WITHOUT TIME ZONE,
    status shift_status NOT NULL DEFAULT 'unfilled',
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    FOREIGN KEY (work_type_id) REFERENCES work_types(id),
    FOREIGN KEY (business_id) REFERENCES business_details(id)
);

INSERT INTO work_types (description) VALUES
('Waiter'),
('Bartender'),
('Barista'),
('Caretaker'),
('Housekeeper'),
('Cleaning');