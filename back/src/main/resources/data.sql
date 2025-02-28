
INSERT INTO customers (id, first_name, last_name, email, phone_number, created_at)
VALUES
    (UUID(), 'Juan', 'Pérez', 'juan.perez@example.com', '+525511223344', NOW()),
    (UUID(), 'Maria', 'Gomez', 'maria.gomez@example.com', '+525533445566', NOW());


INSERT INTO credit_lines (id, customer_id, credit_line_amount, available_credit_line_amount, created_at)
VALUES
    (UUID(), (SELECT id FROM customers WHERE email = 'juan.perez@example.com'), 50000, 20000, NOW()),
    (UUID(), (SELECT id FROM customers WHERE email = 'maria.gomez@example.com'), 100000, 50000, NOW());


INSERT INTO orders (id, customer_id, amount, status, created_at)
VALUES
    (UUID(), (SELECT id FROM customers WHERE email = 'juan.perez@example.com'), 1500, 'PENDING', NOW()),
    (UUID(), (SELECT id FROM customers WHERE email = 'maria.gomez@example.com'), 2500, 'COMPLETED', NOW());
