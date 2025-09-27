CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA IF NOT EXISTS photocatalog;

-- Дать права пользователю
GRANT USAGE ON SCHEMA photocatalog TO postgres;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA photocatalog TO postgres;

CREATE TABLE IF NOT EXISTS photocatalog.photos
(
    id                UUID unique  not null default uuid_generate_v1() primary key,
    description       varchar(255) not null,
    last_modify_date  date         not null,
    content           bytea
);

INSERT INTO photocatalog.photos (description, last_modify_date)
VALUES
('Закат', '2025-09-24'),
('Восход', '2025-09-24');