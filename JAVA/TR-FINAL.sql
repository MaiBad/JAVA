DROP DATABASE IF EXISTS BD_BIBLIOTECA;
CREATE DATABASE BD_BIBLIOTECA;
USE BD_BIBLIOTECA ;

CREATE TABLE ALUMNO (
  `id_alumno` INT NOT NULL AUTO_INCREMENT,
  `nombre_alumno` VARCHAR(45) NOT NULL,
  `apellido_alumno` VARCHAR(45) NULL DEFAULT NULL,
  `edad_alumno` INT NULL DEFAULT NULL,
  `correo_alumno` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_alumno`));

CREATE TABLE LIBRO (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `nombre_libro` VARCHAR(45) NULL DEFAULT NULL,
  `autor_libro` VARCHAR(45) NULL DEFAULT NULL,
  `paginas_libro` INT NULL DEFAULT NULL,
  `editorial_libro` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_libro` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_libro`));

CREATE TABLE PRESTAMO (
  `id_prestamo` INT NOT NULL AUTO_INCREMENT,
  `fecha_ini` DATE NULL DEFAULT NULL,
  `fecha_fin` DATE NULL DEFAULT NULL,
  `id_alumno` INT NULL DEFAULT NULL,
  `id_libro` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_prestamo`),
  INDEX `id_alumno_idx` (`id_alumno` ASC) VISIBLE,
  INDEX `id_libro_idx` (`id_libro` ASC) VISIBLE,
  CONSTRAINT `id_alumno`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `bd_biblioteca`.`alumno` (`id_alumno`),
  CONSTRAINT `id_libro`
    FOREIGN KEY (`id_libro`)
    REFERENCES `bd_biblioteca`.`libro` (`id_libro`));

INSERT INTO LIBRO (nombre_libro,autor_libro,paginas_libro,editorial_libro,fecha_libro) VALUES
('Trilce','Cesar Vallejo',128,'Losada','2007-02-28'),
('La metamorfosis','Franz Kafka',128,'Mestas','2014-03-02'),
('La guerra del fin del mundo','Mario Vargas Llosa',720,'Alfaguara','2019-02-28'),
('20 Poemas de Amor y una Canción Desesperada','Pablo Neruda',82,'Debolsillo','2019-12-31'),
('La tía Julia y el escribidor','Mario Vargas Llosa',472,'Alfaguara','2015-07-11'),
('La divina comedia','Dante Alighieri',336,'Edimat','2016-09-01'),
('La ciudad y los perros','Mario Vargas Llosa',448,'Debolsillo','2018-10-08');

INSERT INTO ALUMNO (nombre_alumno,apellido_alumno,edad_alumno,correo_alumno) VALUES
('Charles Jeferson','Limay Cabello',19,'jeferson@gmail.com'),
('Kert Luis','Huaman Huaman',19,'kert@Outlook.com'),
('Joseph','Ocadio Moreno',21,'joseph@gmail.com'),
('Luis Isaac','Antonio Pizarro',19,'lisaac@hotmail.com'),
('Diana Carolina','Nieves Carbonero',24,'diana@gmail.com'),
('Milagros','Leguía Sanchez',20,'milagrosxd@Outlook.com'),
('Ashley','Castro',19,'ashley@gmail.com');

INSERT INTO PRESTAMO (fecha_ini,fecha_fin,id_alumno,id_libro) VALUES
('2022-06-14','2022-07-14',1,1),
('2022-06-14','2022-09-30',2,4),
('2022-06-14','2022-06-30',4,3),
('2022-06-01','2022-07-01',6,4);


SELECT * FROM LIBRO;
SELECT *from ALUMNO;
SELECT *from PRESTAMO;