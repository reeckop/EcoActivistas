INSERT INTO Cliente (nombre, direccion, telefonos) VALUES
('Juan Pérez', 'Av. Reforma 123, CDMX', '555-1234'),
('María López', 'Calle Hidalgo 45, Guadalajara', '333-5678'),
('Carlos Ramírez', 'Blvd. Universidad 890, Monterrey', '818-9999'),
('Ana Torres', 'Av. Juárez 456, Puebla', '222-1111'),
('Luis Martínez', 'Calle Morelos 789, Mérida', '999-2222');

INSERT INTO Problema (fch_ini, fch_fin, estado, idCliente) VALUES
('2026-01-10', NULL, 'pendiente', 1),
('2026-01-05', '2026-01-20', 'concluido', 2),
('2026-01-15', NULL, 'pendiente', 3),
('2026-01-01', '2026-01-12', 'cancelado', 1),
('2026-02-01', NULL, 'pendiente', 4),
('2026-02-03', NULL, 'pendiente', 5);

INSERT INTO Activista (nombre, telefono, fchIngreso) VALUES
('Sofía Hernández', '555-7777', '2024-03-15'),
('Miguel Castro', '333-8888', '2023-07-10'),
('Laura Jiménez', '818-6666', '2025-01-05'),
('Diego Morales', '222-4444', '2022-11-20'),
('Valeria Cruz', '999-3333', '2024-09-01');


INSERT INTO Problema_Activista (idProblema, idActivista) VALUES
(1,1),
(1,2),
(2,3),
(3,1),
(3,4),
(4,2),
(5,5),
(6,1),
(6,3),
(6,5);
