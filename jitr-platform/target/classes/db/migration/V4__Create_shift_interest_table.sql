CREATE TABLE shift_interest (
    id SERIAL PRIMARY KEY,
    shift_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    declared_interest_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    FOREIGN KEY (shift_id) REFERENCES shifts(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE (shift_id, user_id)
);
