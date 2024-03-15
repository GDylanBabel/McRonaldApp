-- Crear empleados
INSERT INTO Empleado (nombre) VALUES ('Juan'), ('María'), ('Carlos');

-- Crear productos
INSERT INTO Producto (nombre, stockDisponible) VALUES
('Producto A', 10),
('Producto B', 20),
('Producto C', 15);

-- Crear productos de carta
INSERT INTO ProductoCarta (producto_id, precio) VALUES
(1, 10.5),
(2, 15.75),
(3, 20.0);

-- Crear pedidos
INSERT INTO Pedido (identificador, empleado_id, precioTotal) VALUES
('Pedido 001', 1, 50.25),
('Pedido 002', 2, 30.0),
('Pedido 003', 3, 45.75);

-- Asignar productos a los pedidos
INSERT INTO ProductoPedido (productoCarta_id, pedido_id, productAmount) VALUES
(1, 1, 2),
(2, 1, 1),
(3, 2, 3),
(1, 3, 1),
(2, 3, 2);
