CREATE database hotel_alura;
USE hotel_alura;

CREATE TABLE reservas(
id INT NOT NULL auto_increment,
fecha_entrada DATE NOT NULL,
fecha_salida DATE NOT NULL,
valor VARCHAR(50),
forma_de_pago VARCHAR(50)NOT NULL,
PRIMARY KEY (id)
);
CREATE TABLE huespedes(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50)not null,
apellido VARCHAR(50)NOT NULL,
fecha_nacimiento DATE NOT NULL,
nacionalidad VARCHAR(50)NOT NULL,
telefono VARCHAR(50)NOT NULL,
id_reserva INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_reserva) REFERENCES reservas(id)
);
CREATE TABLE usuarios(
nombre VARCHAR(50),
contraseña VARCHAR(50)
);
INSERT INTO usuarios (nombre, contraseña) VALUES('jorge', '12345');
INSERT INTO usuarios (nombre, contraseña) VALUES('admin', 'admin');

 