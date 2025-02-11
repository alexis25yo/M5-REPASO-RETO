-- Creación de la tabla de clientes
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefono VARCHAR(15),
    direccion VARCHAR(255),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Creación de la tabla de préstamos
CREATE TABLE prestamo (
    id SERIAL PRIMARY KEY,
    monto DECIMAL(10,2) NOT NULL,
    interes DECIMAL(5,2) NOT NULL,
    duracion_meses INT NOT NULL,
    estado VARCHAR(20) DEFAULT 'Pendiente',
    cliente_id INT REFERENCES cliente(id) ON DELETE CASCADE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Creación de la tabla de historial de préstamos
CREATE TABLE historial_prestamos (
    id SERIAL PRIMARY KEY,
    prestamo_id INT REFERENCES prestamo(id) ON DELETE CASCADE,
    estado VARCHAR(20) NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    comentario TEXT
);

-- Creación de la tabla de simulación de cuotas
CREATE TABLE simulacion_cuotas (
    id SERIAL PRIMARY KEY,
    monto DECIMAL(10,2) NOT NULL,
    interes DECIMAL(5,2) NOT NULL,
    duracion_meses INT NOT NULL,
    cuota_mensual DECIMAL(10,2),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insertar clientes
INSERT INTO cliente (nombre, email, telefono, direccion) VALUES
('Juan Pérez', 'juan.perez@mail.com', '555-1234', 'Calle Ficticia 123'),
('María López', 'maria.lopez@mail.com', '555-5678', 'Avenida Real 456'),
('Carlos García', 'carlos.garcia@mail.com', '555-9876', 'Calle Sol 789');

-- Insertar préstamos para Juan Pérez
INSERT INTO prestamo (monto, interes, duracion_meses, cliente_id) VALUES
(50000, 5.5, 24, 1),
(100000, 6.2, 36, 1),
(150000, 5.8, 48, 1),
(200000, 7.0, 60, 1),
(250000, 6.5, 72, 1);

-- Insertar préstamos para María López
INSERT INTO prestamo (monto, interes, duracion_meses, cliente_id) VALUES
(30000, 5.0, 18, 2),
(60000, 5.6, 24, 2),
(90000, 6.0, 36, 2),
(120000, 6.4, 48, 2),
(150000, 7.2, 60, 2);

-- Insertar préstamos para Carlos García
INSERT INTO prestamo (monto, interes, duracion_meses, cliente_id) VALUES
(20000, 5.0, 12, 3),
(40000, 5.8, 24, 3),
(70000, 6.1, 36, 3),
(100000, 6.5, 48, 3),
(120000, 7.0, 60, 3);

-- Historial de los préstamos de Juan Pérez
INSERT INTO historial_prestamos (prestamo_id, estado, comentario) VALUES
(1, 'Aprobado', 'Aprobado por el banco.'),
(2, 'Aprobado', 'Aprobado tras revisión de crédito.'),
(3, 'Rechazado', 'Rechazado por bajo puntaje crediticio.'),
(4, 'Aprobado', 'Aprobado, condiciones negociadas.'),
(5, 'Aprobado', 'Aprobado tras revisión final.');

-- Historial de los préstamos de María López
INSERT INTO historial_prestamos (prestamo_id, estado, comentario) VALUES
(6, 'Aprobado', 'Aprobado tras validación de ingresos.'),
(7, 'Aprobado', 'Aprobado con tasa de interés ajustada.'),
(8, 'Aprobado', 'Aprobado por cliente con buen historial.'),
(9, 'Rechazado', 'Rechazado por antecedentes financieros.'),
(10, 'Aprobado', 'Aprobado, condiciones mejoradas para cliente.');

-- Historial de los préstamos de Carlos García
INSERT INTO historial_prestamos (prestamo_id, estado, comentario) VALUES
(11, 'Aprobado', 'Aprobado, condiciones estándar.'),
(12, 'Rechazado', 'Rechazado por falta de aval.'),
(13, 'Aprobado', 'Aprobado con condiciones flexibles.'),
(14, 'Aprobado', 'Aprobado tras revisión de activos.'),
(15, 'Aprobado', 'Aprobado con tasa competitiva.');


SELECT p.id AS prestamo_id,
       p.monto,
       p.interes,
       p.duracion_meses,
       p.estado,
       p.fecha_creacion,
       p.fecha_actualizacion
FROM prestamo p
JOIN cliente c ON p.cliente_id = c.id
WHERE c.nombre = 'María López'
ORDER BY p.fecha_creacion DESC
LIMIT 3;


