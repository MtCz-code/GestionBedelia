-- Tabla Usuario
CREATE TABLE Usuario (
    idUsuario SERIAL PRIMARY KEY,
    contraseña VARCHAR(60) NOT NULL,  -- Hash de la contraseña
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL
);

-- Tabla Bedel
CREATE TABLE Bedel (
    idUsuario INT PRIMARY KEY REFERENCES Usuario(idUsuario),
    idBedel SERIAL,
    turno VARCHAR(10) NOT NULL,
    habilitado BOOLEAN NOT NULL
);

-- Tabla Administrador
CREATE TABLE Administrador (
    idUsuario INT PRIMARY KEY REFERENCES Usuario(idUsuario),
    idAdministrador SERIAL
);

-- Tabla Reserva
CREATE TABLE Reserva (
    idReserva SERIAL PRIMARY KEY,
    idDocente INT NOT NULL,
    nombreDocente VARCHAR(50) NOT NULL,
    apellidoDocente VARCHAR(50) NOT NULL,
    emailDocente VARCHAR(50) NOT NULL,
    idCatedra INT NOT NULL,
    nombreCatedra VARCHAR(50) NOT NULL,
    fechaRegistro TIMESTAMP NOT NULL,
    idBedel INT REFERENCES Bedel(idBedel)
);

-- Tabla DetalleReserva
CREATE TABLE DetalleReserva (
    idDetalleReserva SERIAL,
    idReserva INTEGER REFERENCES Reserva(idReserva),
    horarioInicio TIME NOT NULL,
    fecha DATE NOT NULL,
    cantModulos INTEGER NOT NULL,
    diaReserva VARCHAR(10) NOT NULL,
    idAula INT REFERENCES AulaGeneral(idAula),
    CONSTRAINT detalleReserva_pk PRIMARY KEY(idDetalleReserva),
    CONSTRAINT idAulaHorarioInicioFecha_uq UNIQUE(idAula, horarioInicio, fecha)
);

-- Tabla AulaGeneral
CREATE TABLE AulaGeneral (
    idAula SERIAL PRIMARY KEY,
    tipo VARCHAR(15) NOT NULL,
    ubicacion VARCHAR(30) NOT NULL,
    estado BOOLEAN NOT NULL,
    capacidad INTEGER NOT NULL,
    piso INTEGER NOT NULL,
    tipoDePizarron VARCHAR(15),
    ventiladores BOOLEAN,
    aireAcondicionado BOOLEAN,
    habilitado BOOLEAN NOT NULL,
    CONSTRAINT uq_ubicacion_piso UNIQUE(ubicacion, piso) 
);

-- Tabla AulaMultimedios
CREATE TABLE AulaMultimedios (
    idAula SERIAL PRIMARY KEY REFERENCES AulaGeneral(idAula),
    televisor BOOLEAN,
    canon BOOLEAN,
    computadora BOOLEAN
);

-- Tabla AulaLaboratorio
CREATE TABLE AulaLaboratorio (
    idAula SERIAL PRIMARY KEY REFERENCES AulaGeneral(idAula),
    cantidadDePCs INTEGER
);

-- Tabla ReservaPeriodica
CREATE TABLE ReservaPeriodica (
   idReserva INTEGER REFERENCES Reserva(idReserva),
    idReservaPeriodica SERIAL PRIMARY KEY,
    tipo VARCHAR(15) NOT NULL,
    diasSemana JSON NOT NULL  -- Almacenamos dias de la semana en formato JSON
);

-- Tabla ReservaEsporadica
CREATE TABLE ReservaEsporadica (
    idReserva INTEGER REFERENCES Reserva(idReserva),
    idReservaEsporadica SERIAL PRIMARY KEY
   );

-- Tabla Cuatrimestre
CREATE TABLE Cuatrimestre (
    idCuatrimestre SERIAL PRIMARY KEY,
    fechaInicioCuatrimestre DATE NOT NULL,
    fechaFinCuatrimestre DATE NOT NULL
);

-- Relación entre Cuatrimestre y ReservaPeriodica
CREATE TABLE PeriodoAsignado (
    idCuatrimestre INT NOT NULL REFERENCES Cuatrimestre(idCuatrimestre),
    idReservaPeriodica INT NOT NULL REFERENCES ReservaPeriodica(idReservaPeriodica),
    PRIMARY KEY (idCuatrimestre, idReservaPeriodica)
);


