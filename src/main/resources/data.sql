
-- Crear tabla Asignatura
CREATE TABLE IF NOT EXISTS Asignaturas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    creditos INT NOT NULL
);

-- Crear tabla Estudiante
CREATE TABLE IF NOT EXISTS Estudiantes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    edad INT NOT NULL
);



-- Insertar registros en Asignatura
INSERT INTO Asignaturas (nombre, creditos) VALUES
('Matemáticas', 3),
('Física', 4),
('Química', 4),
('Biología', 3),
('Historia', 2),
('Geografía', 2),
('Literatura', 3),
('Arte', 3),
('Música', 2),
('Filosofía', 3),
('Programación', 5),
('Cálculo', 4),
('Estadística', 3),
('Economía', 3),
('Psicología', 3),
('Sociología', 3),
('Antropología', 3),
('Derecho', 4),
('Arquitectura', 5),
('Diseño Gráfico', 4);

-- Insertar registros en Estudiante
INSERT INTO Estudiantes (nombre, apellido, edad) VALUES
('Juan', 'Pérez', 20),
('Ana', 'García', 22),
('Luis', 'Martínez', 21),
('María', 'López', 19),
('Carlos', 'Fernández', 23),
('Laura', 'Ramírez', 20),
('Sofía', 'González', 22),
('Pedro', 'Sánchez', 21),
('Javier', 'Torres', 20),
('Gabriela', 'Hernández', 19),
('Daniel', 'Martín', 22),
('Isabel', 'Jiménez', 21),
('Fernando', 'Morales', 20),
('Raquel', 'Cruz', 23),
('Andrés', 'Rojas', 22),
('Verónica', 'Pérez', 20),
('Nicolás', 'Salazar', 21),
('Patricia', 'Vásquez', 19),
('Diego', 'Mendoza', 22),
('Cristina', 'Ortega', 21),
('Mónica', 'Alvarez', 20);



-- Relacionar Estudiantes con Asignaturas
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) VALUES
(1, 1),  -- Juan -> Matemáticas
(1, 2),  -- Juan -> Física
(2, 1),  -- Ana -> Matemáticas
(2, 3),  -- Ana -> Química
(3, 4),  -- Luis -> Biología
(4, 1),  -- María -> Matemáticas
(4, 4),  -- María -> Biología
(5, 2),  -- Carlos -> Física
(6, 3),  -- Lucía -> Química
(7, 5),  -- Pedro -> Historia
(8, 6),  -- Sofía -> Geografía
(9, 7),  -- Fernando -> Inglés
(10, 8), -- Isabel -> Programación
(11, 9), -- Diego -> Arte
(12, 10), -- Claudia -> Música
(13, 11), -- Roberto -> Filosofía
(14, 12), -- Natalia -> Educación Física
(15, 1),  -- Gabriel -> Matemáticas
(16, 2),  -- Patricia -> Física
(17, 3),  -- Hugo -> Química
(18, 4),  -- Verónica -> Biología
(19, 5),  -- Javier -> Historia
(20, 6);  -- Carla -> Geografía