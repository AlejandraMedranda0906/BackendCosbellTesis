-- Tabla de usuarios
CREATE TABLE IF NOT EXISTS users (
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role_id  INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
    );

-- Tabla de roles
CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    name varchar(25 )  NOT NULL UNIQUE
    );

-- Tabla de permisos
CREATE TABLE IF NOT EXISTS permission (
    id BIGSERIAL PRIMARY KEY,
    resource_path VARCHAR(255) NOT NULL,
    http_method VARCHAR(10) NOT NULL
    );

-- Relación rol-permiso
CREATE TABLE IF NOT EXISTS role_permission (
    role_id BIGINT,
    permission_id BIGINT,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (permission_id) REFERENCES permission(id)
    );

-- Tabla de servicios
CREATE TABLE IF NOT EXISTS service (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    duration INT NOT NULL,
    price DECIMAL(10,2) NOT NULL
    );

-- Tabla de citas
CREATE TABLE IF NOT EXISTS appointment (
   id SERIAL PRIMARY KEY,
    service_id BIGINT NOT NULL,
    date DATE NOT NULL,
    time TIME NOT NULL,
     email VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    FOREIGN KEY (service_id) REFERENCES service(id)
    );
