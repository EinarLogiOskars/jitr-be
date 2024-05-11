ALTER TABLE shifts
ADD COLUMN selected_user_id BIGINT NULL,
ADD CONSTRAINT fk_selected_user
FOREIGN KEY (selected_user_id) REFERENCES users(id);