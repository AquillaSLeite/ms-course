INSERT INTO users (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$.sxtT7oIb4bGZQH8AVFVGujjF1eyoHIT8B0RXRi22D3Zc1aYtKTQq');
INSERT INTO users (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$.sxtT7oIb4bGZQH8AVFVGujjF1eyoHIT8B0RXRi22D3Zc1aYtKTQq');

INSERT INTO roles (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);