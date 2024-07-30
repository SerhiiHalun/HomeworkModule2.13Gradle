INSERT INTO client (name)
VALUES
    ('Ivan Petrovych'),
    ('Olena Sydorivna'),
    ('Marina Ivanivna'),
    ('Petro Oleksandrovych'),
    ('Andrii Mykolaiovych'),
    ('Nataliia Vasylivna'),
    ('Viktoriia Olehivna'),
    ('Oleksandr Viktorovych'),
    ('Yuliia Pavlivna'),
    ('Maksym Oleksiiovych');
INSERT INTO planet (id, name)
VALUES
    ('EAR', 'Earth'),
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn');
INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'EAR', 'MARS'),
    (2, 'JUP', 'EAR'),
    (3, 'VEN', 'EAR'),
    (4, 'VEN', 'SAT'),
    (5, 'JUP', 'MARS'),
    (6, 'VEN', 'SAT'),
    (7, 'MARS', 'VEN'),
    (8, 'VEN', 'SAT'),
    (9, 'JUP', 'EAR'),
    (10, 'SAT', 'MARS');
