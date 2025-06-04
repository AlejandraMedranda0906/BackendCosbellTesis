-- Tabla de usuarios
CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
    );

-- Tabla de roles
CREATE TABLE IF NOT EXISTS role (
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(25) NOT NULL
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
    FOREIGN KEY (role_id) REFERENCES role(id),
    FOREIGN KEY (permission_id) REFERENCES permission(id)
    );

-- Tabla de servicios
CREATE TABLE IF NOT EXISTS servicio (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    duracion INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL
    );

-- Ejemplo de inserción de servicios
INSERT INTO servicio (nombre, duracion, precio) VALUES
      ('Masaje Relajante', 60, 30.00),
       ('Facial Hidratante', 45, 25.00),
       ('Manicura', 30, 15.00);

-- Tabla de citas
CREATE TABLE IF NOT EXISTS cita (
       id BIGSERIAL PRIMARY KEY,
       servicio_id BIGINT NOT NULL,
        fecha DATE NOT NULL,
        hora TIME NOT NULL,
        email VARCHAR(50) NOT NULL,
    estado VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE',
    FOREIGN KEY (servicio_id) REFERENCES servicio(id)
    );