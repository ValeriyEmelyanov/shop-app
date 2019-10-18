
DELETE FROM products;
DELETE FROM users;
DELETE FROM authorities;

INSERT INTO products (id, title, price) VALUES
(1, 'Milk', 80),
(2, 'Cheese', 320),
(3, 'Coca-cola', 90);

INSERT INTO users (username, password, enabled) VALUES
('admin', '{noop}12345', true),
('user', '{noop}12345', true);

INSERT INTO authorities (username, authority) VALUES
('admin', 'ROLE_ADMIN'),
('user', 'ROLE_USER');                                                     ;
